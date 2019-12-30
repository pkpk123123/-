package biz;

import dao.*;
import entity.*;
import java.util.*;

public class CourseBiz {
	CourseDao courseDao;
	private Course course;
	private HashMap<String,IEntity> courses;
	public void printAllCourses()throws Exception{
		courseDao = CourseDao.getInstance();
		courseDao.printAll();
	}
	
}
