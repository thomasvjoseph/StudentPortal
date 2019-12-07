package com.studentportal.dao;

import java.util.ArrayList;

import com.studentportal.model.Day;
import com.studentportal.model.Week;

public interface MarkDao {

	void addmark(Day day);

	void weekMark(Week week);

	ArrayList<Day> getDayMark(String uid);

	ArrayList<Week> getWeekMarks(String uid);

	ArrayList<Day> searchMArk(String uid, String date);

}
