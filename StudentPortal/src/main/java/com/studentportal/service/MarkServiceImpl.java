package com.studentportal.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import com.studentportal.dao.MarkDao;
import com.studentportal.model.Day;
import com.studentportal.model.Week;



public class MarkServiceImpl implements MarkService{
	@Autowired
	public MarkDao markDao;

	public void dayamark(Day day) {
		 markDao.addmark(day);
		
	}

	public void weekMark(Week week) {
		markDao.weekMark(week);
		
	}

	public ArrayList<Day> getMarks(String id) {
		
		return markDao.getDayMark(id);
	}

	public ArrayList<Week> weekMarks(String uid) {
		return markDao.getWeekMarks(uid);
	}

	public ArrayList<Day> searchMark(String uid, String date) {
		return markDao.searchMArk(uid,date);
	}

	
}
