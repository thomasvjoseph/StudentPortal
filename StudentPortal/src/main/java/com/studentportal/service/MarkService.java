package com.studentportal.service;

import java.util.ArrayList;

import com.studentportal.model.Day;
import com.studentportal.model.Week;

public interface MarkService {

	void dayamark(Day day);

	void weekMark(Week week);

	ArrayList<Day> getMarks(String uid);

	ArrayList<Week> weekMarks(String uid);
	
	ArrayList<Day> searchMark(String uid, String date);

}
