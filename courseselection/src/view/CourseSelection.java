package view;
import java.util.Scanner;

import javax.swing.JOptionPane;

import biz.CourseBiz;
import biz.SCBiz;
public class CourseSelection {

	public static void show()throws Exception{
		Object[] possibleValues = { "δѡ��", "�鿴��ѡ�γ�" ,"ѡ�������γ�","��ѡ��ѡ��γ�"}; 
		String selection = (String)JOptionPane.showInputDialog(null, "����Ҫ?", "��ʦѡ��ϵͳ", 
				JOptionPane.INFORMATION_MESSAGE, null,  possibleValues, possibleValues[0]);
		CourseBiz cb=new CourseBiz();
		SCBiz sb=new SCBiz();
		String courseId="";
		Scanner in=new Scanner(System.in);
		switch (selection){
		case "�鿴��ѡ�γ�":
			sb.printSelectedCourse();
			break;
		case "ѡ�������γ�":
			cb.printAllCourses();
			System.out.println("��������Ҫѡ��Ŀγ̵ı��");
			courseId=in.nextLine();
			sb.selectCourse(courseId);
			break;
		case "��ѡ��ѡ��γ�":
			System.out.println(MainUI.whoLogin().getStudentName()+"ͬѧ,������ѡ��γ�,����������ʾ,����ϵͳ����ʾ������");
			boolean haveSelected=sb.printSelectedCourse();
			if(haveSelected){
				System.out.println("��Ҫ��ѡ��һ���γ�?");
				courseId=in.nextLine();
				sb.deleteOneCourse(courseId);
			}
			
			break;
		}
	}

}
