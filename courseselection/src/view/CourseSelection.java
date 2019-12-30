package view;
import java.util.Scanner;

import javax.swing.JOptionPane;

import biz.CourseBiz;
import biz.SCBiz;
public class CourseSelection {

	public static void show()throws Exception{
		Object[] possibleValues = { "未选择", "查看已选课程" ,"选择其他课程","退选已选择课程"}; 
		String selection = (String)JOptionPane.showInputDialog(null, "您是要?", "安师选课系统", 
				JOptionPane.INFORMATION_MESSAGE, null,  possibleValues, possibleValues[0]);
		CourseBiz cb=new CourseBiz();
		SCBiz sb=new SCBiz();
		String courseId="";
		Scanner in=new Scanner(System.in);
		switch (selection){
		case "查看已选课程":
			sb.printSelectedCourse();
			break;
		case "选择其他课程":
			cb.printAllCourses();
			System.out.println("请输入您要选择的课程的编号");
			courseId=in.nextLine();
			sb.selectCourse(courseId);
			break;
		case "退选已选择课程":
			System.out.println(MainUI.whoLogin().getStudentName()+"同学,若您已选择课程,则在下面显示,否则系统会提示不存在");
			boolean haveSelected=sb.printSelectedCourse();
			if(haveSelected){
				System.out.println("您要退选哪一个课程?");
				courseId=in.nextLine();
				sb.deleteOneCourse(courseId);
			}
			
			break;
		}
	}

}
