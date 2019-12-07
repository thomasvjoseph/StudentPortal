package com.studentportal.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.studentportal.model.Day;
import com.studentportal.model.Week;
import com.studentportal.service.MarkService;

@Controller
public class MarkController {
	@Autowired
	public MarkService marService;
	@RequestMapping(value="/daymark",method=RequestMethod.POST)
	public ModelAndView dayMark(HttpServletRequest request, HttpServletResponse response, Day day)
	{
		marService.dayamark(day);
		return new ModelAndView("admin_home");
		
	}
	@RequestMapping(value="/weekmark",method=RequestMethod.POST)
	public ModelAndView weekMark(HttpServletRequest request, HttpServletResponse response, Week week)
	{
		marService.weekMark(week);
		return new ModelAndView("admin_home");
		
	}
	@RequestMapping(value="/dayView",method=RequestMethod.POST)
	public ModelAndView viewMark(HttpServletRequest request, HttpServletResponse response,Day day)
	{
		String id = request.getParameter("duid");
		ArrayList<Day> mark = marService.getMarks(id);
		ModelAndView mav=new ModelAndView("dayMark");
		mav.addObject("id",id);
		mav.addObject("mark",mark);
		return mav;	
	}
	@RequestMapping(value="/weekView",method=RequestMethod.POST)
	public ModelAndView viewWeek(HttpServletRequest request, HttpServletResponse response,Day day)
	{
		String uid = request.getParameter("wuid");		
		ArrayList<Week> wm = marService.weekMarks(uid);
		ModelAndView mav=new ModelAndView("weekMark");
		mav.addObject("id",uid);
		mav.addObject("wm",wm);
		return mav;	
	}
	@RequestMapping(value="/markSearch",method=RequestMethod.POST)
	public ModelAndView markSearchk(HttpServletRequest request, HttpServletResponse response,Day day)
	{
		String uid= request.getParameter("duid");
		String date = request.getParameter("fdate");
		ArrayList<Day> dm = marService.searchMark(uid,date);
		ModelAndView mav = new ModelAndView("student_home");
		mav.addObject("date",dm);
		return mav;
		
	}
}
