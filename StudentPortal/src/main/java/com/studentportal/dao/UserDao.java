package com.studentportal.dao;

import java.util.ArrayList;

import com.studentportal.model.Login;
import com.studentportal.model.User;

public interface UserDao {
	int register(User user);
	User validateUser(Login login);
	ArrayList<User> RetriveUser();
	ArrayList<User> getNames(String x);
}
