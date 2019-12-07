package com.studentportal.service;

import java.util.ArrayList;

import com.studentportal.model.Login;
import com.studentportal.model.User;

public interface UserService {
	User validateUser(Login login);

	int register(User user);

	ArrayList<User> RetriveUser();

	ArrayList<User> getNames(String x);

	

}
