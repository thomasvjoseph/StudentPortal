package com.studentportal.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.studentportal.dao.UserDao;
import com.studentportal.model.Login;
import com.studentportal.model.User;

public class UserServiceImpl implements UserService{
	@Autowired
	public UserDao userDao;
	public User validateUser(Login login) {
		return userDao.validateUser(login);		
	}
	public int register(User user) {
		userDao.register(user);
		return 0;		
	}
	public ArrayList<User> RetriveUser() {
		return userDao.RetriveUser();
		
	}
	public ArrayList<User> getNames(String x) {
		
		return userDao.getNames(x);
		
		
	}
	

}
