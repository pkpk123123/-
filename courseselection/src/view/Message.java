package view;

import biz.StudentBiz;

public class Message{
	public static void show()throws Exception{
		StudentBiz sb=new StudentBiz();
		sb.printStudentMessage();
	}
}
