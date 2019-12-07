package com.studentportal.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.studentportal.service.*;
import com.google.gson.Gson;
import com.studentportal.model.Login;
import com.studentportal.model.User;

@Controller
public class UserController {
	@Autowired
	public UserService userService;
	@RequestMapping(value="/")
	public ModelAndView index() {
		ModelAndView mv   = new ModelAndView("index");
		return mv;
	}
	@RequestMapping(value="signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView("login");
		return mv;		
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Login login) {
		ModelAndView mav= null;
		User user=userService.validateUser(login);
		if(null !=user) {
			String s = user.getUsername();
			System.out.println(s);
			if("admin".equals(s)) {
				mav = new ModelAndView("admin_home");
				mav.addObject("firstname",user.getFname());
			}
			else
			{
				mav = new ModelAndView("student_home");
				mav.addObject("id",user.getUsername());
				mav.addObject("firstname",user.getFname());
			}
			System.out.println("login action");
		}
		else
		{
			mav = new ModelAndView("login");
			mav.addObject("message","username or password wrong");
		}
		return mav;	
	}
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, User user) {	
		String a = "user already und monuse";
		ModelAndView mav= null;
	int x=	userService.register(user);
	System.out.println(x);
		if(x==0) {
			mav = new ModelAndView("admin_home");
			return mav;
		}
		else {
			mav =  new ModelAndView("admin_home");
			mav.addObject("a",a);
			return mav;
		}		
	}
	@RequestMapping(value="day",method = RequestMethod.GET )
	public ModelAndView day() {
		
		ArrayList<User> user= userService.RetriveUser();
		ModelAndView mav=new ModelAndView("day");
		mav.addObject("user", user);
		return mav;
		
	}
	@RequestMapping(value="week",method = RequestMethod.GET )
	public ModelAndView week() {
		
		ArrayList<User> user= userService.RetriveUser();
		ModelAndView mav=new ModelAndView("week");
		mav.addObject("user", user);
		return mav;
		
	}
	@RequestMapping(value="nameSelect",method=RequestMethod.POST)
	@ResponseBody
	public String name(HttpServletRequest request, HttpServletResponse response, User user)
	{
		String x = request.getParameter("uname");
		ArrayList<User> n = userService.getNames(x);
		String json = new Gson().toJson(n);
		return json;
		
	}
	
}

