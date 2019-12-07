package com.studentportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.studentportal.model.Day;
import com.studentportal.model.Week;

public class MarkDaoImpl implements MarkDao{
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	public void addmark(Day day) {
		String x = day.getDate();
		int f =0;
		String s = "select * from tbl_day_mark";
		ArrayList<Day> m = (ArrayList<Day>) jdbcTemplate.query(s, new MMark());
		for(Day d:m) {
			String z = d.getDate();
			if(z.equals(x)) {
				f=1;
				break;
			}
		}
		if(f==0)
		{
		String sql = "insert into tbl_day_mark ( `date`, `viva`, `cc`, `pc`, `uname`)values(?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {day.getDate(),day.getViva(),day.getCc(),day.getPc(),day.getUname()});
		}
	}
	public class MMark implements RowMapper<Day>{

		public Day mapRow(ResultSet rs, int rowNum) throws SQLException {
			Day m = new Day();
			m.setDate(rs.getString("date"));
			return m;
		}
		
	}
	public void weekMark(Week week) {
		String x = week.getSdate();
		String y = week.getEdate();
		int f=0;
		String s = "select * from tbl_week_mark";
		ArrayList<Week> w = (ArrayList<Week>) jdbcTemplate.query(s,new Weekmark());
		for(Week q:w) {
			String a = q.getSdate();
			String b = q.getEdate();
			if((x.equals(a))&&(y.equals(b)))
			{
				System.out.println(x);
				System.out.println(y);
				System.out.println(a);
				System.out.println(b);
				f=1;
				break;
			}
		}
		if(f==0) {
			String sql = "insert into tbl_week_mark (`sdate`, `edate`, `cc`, `viva`, `pc`, `uname` )values(?,?,?,?,?,?)";
			jdbcTemplate.update(sql,new Object[] {week.getSdate(),week.getEdate(),week.getCc(),week.getViva(),week.getPc(),week.getUname()});
		}
	}
	class Weekmark implements RowMapper<Week>{

		public Week mapRow(ResultSet rs, int rowNum) throws SQLException {
			Week wk = new Week();
			wk.setSdate(rs.getString("sdate"));
			wk.setEdate(rs.getString("edate"));
			return wk;
		}
		
	}
	public ArrayList<Day> getDayMark(String id) {
		String sql = "select * from tbl_day_mark where uname ='"+id+"'";	
		ArrayList<Day> mark = (ArrayList<Day>)jdbcTemplate.query(sql,new Mark());
		return mark;
	}
	class Mark implements RowMapper<Day>{

		public Day mapRow(ResultSet rs, int rowNum) throws SQLException {
			Day mark = new Day();
			mark.setDate(rs.getString("date"));
			mark.setViva(rs.getString("viva"));
			mark.setCc(rs.getString("cc"));
			mark.setPc(rs.getString("pc"));
			System.out.println(rs.getString("cc"));
			return mark;
		}
		
	}
	public ArrayList<Week> getWeekMarks(String uid) {
		System.out.println(uid);
		String sql = "select * from tbl_week_mark where uname ='"+uid+"'";
		System.out.println(sql);
		ArrayList<Week> mark = (ArrayList<Week>) jdbcTemplate.query(sql,new Wmark());
		return mark;
	}
	class Wmark implements RowMapper<Week>{

		public Week mapRow(ResultSet rs, int rowNum) throws SQLException {
			Week w = new Week();
			System.out.println(rs.getString("cc"));
			System.out.println(rs.getString("pc"));
			w.setSdate(rs.getString("sdate"));
			w.setEdate(rs.getString("edate"));
			w.setCc(rs.getString("cc"));
			w.setPc(rs.getString("pc"));
			w.setViva(rs.getString("viva"));
			return w;
		}

		
		
	}
	public ArrayList<Day> searchMArk(String uid, String date) {
		String sql = "select * from tbl_day_mark where uname='"+uid+"' and date='"+date+"'";
		ArrayList<Day> mark = (ArrayList<Day>) jdbcTemplate.query(sql, new SearchMark());
		return mark;
	}
	class SearchMark implements RowMapper<Day>{

		public Day mapRow(ResultSet rs, int rowNum) throws SQLException {
			Day day = new Day();
			day.setCc(rs.getString("cc"));
			day.setDate(rs.getString("date"));
			day.setPc(rs.getString("pc"));
			day.setViva(rs.getString("viva"));
			return day;
		}
		
	}
	

}
