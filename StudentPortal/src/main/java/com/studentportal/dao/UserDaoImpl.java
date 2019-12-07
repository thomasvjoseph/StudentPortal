package com.studentportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.studentportal.model.Login;
import com.studentportal.model.User;

public class UserDaoImpl implements UserDao{
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	public User validateUser(Login login) {
		String sql = "select * from tbl_user where username='"+login.getUsername()+"' and password='"+login.getPassword()+"'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size()>0 ?users.get(0):null;
	}
	class UserMapper implements RowMapper<User>{

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setFname(rs.getString("fname"));
			user.setLanme(rs.getString("lname"));
			user.setEmail(rs.getString("email"));
			user.setPhone(rs.getString("phone"));
			user.setDob(rs.getString("dob"));
			return user;
		}

}
	public int register(User user) {
		int f=0;
		String x = user.getUsername();
		String s = "select * from tbl_user";
		ArrayList<User> name = (ArrayList<User>) jdbcTemplate.query(s, new UName());
		for(User u: name) {
			String nn=u.getUsername();
			System.out.println(nn);
			if(x.equals(nn)) {
				System.out.println("und");
				f=1;
				break;
			}			
		}	if(f==0)
			{
				String sql = "insert into tbl_user values(?,?,?,?,?,?,?,?)";
				jdbcTemplate.update(sql,new Object[] {user.getFname(),user.getLanme(),user.getEmail(),user.getPhone(),user.getDob(),user.getBatch(),user.getUsername(),user.getPassword()});		
			}
		return f;				
	} 
	class UName implements RowMapper<User>{

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			return user;
		}
		
	}
	public ArrayList<User> RetriveUser() {
		String sql="select * from tbl_user where username != 'admin' and password !='admin'";
		ArrayList<User> users=(ArrayList<User>) jdbcTemplate.query(sql,new Reterive());
			return users;
		}
	class Reterive implements RowMapper<User>
	{
		public User mapRow(ResultSet rs,int arg1) throws SQLException
		{
			User user=new User();
			user.setUsername(rs.getString("username"));			
			return user;
		}
	}
	public ArrayList<User> getNames(String x) {
		System.out.println(x);
		String sql = "select * from tbl_user where username ='"+x+"'";		
		ArrayList<User> name = (ArrayList<User>)jdbcTemplate.query(sql, new Names());
		return name;
	}
	class Names implements RowMapper<User>{

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User name = new User();
			name.setFname(rs.getString("fname"));
			name.setLanme(rs.getString("lname"));
			name.setBatch(rs.getString("batch"));
			return name;
		}
		
	}
	
		
	}

