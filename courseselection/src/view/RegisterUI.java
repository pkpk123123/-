package view;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

import biz.StudentBiz;
import dao.StudentDao;

public class RegisterUI {

	public static void show() throws Exception{
//		System.out.println("请输入学号：");
		String studentNo=(String)JOptionPane.showInputDialog(null,"请输入你的学号：\n","学号",
				JOptionPane.PLAIN_MESSAGE,null,null,"在这输入");  
//		System.out.println("请输入姓名：");
		String studentName =(String)JOptionPane.showInputDialog(null,"请输入你的姓名：\n",
				"姓名",JOptionPane.PLAIN_MESSAGE,null,null,"在这输入");  
//		System.out.println("请输入性别：");
		Object[] possibleValues = { "未选择", "男", "女" }; 
		String studentGender = (String)JOptionPane.showInputDialog(null, "请选择您的性别", "您选择?", 
				JOptionPane.INFORMATION_MESSAGE, null,  possibleValues, possibleValues[0]);
//		System.out.println("请输入年龄：");
		int studentAge = Integer.parseInt((String)JOptionPane.showInputDialog(null,
				"请输入你的年龄：\n","年龄",JOptionPane.PLAIN_MESSAGE,null,
				null,"在这输入"));		
//		System.out.println("请输入院系：");
		String studentDepartment =(String)JOptionPane.showInputDialog(null,
				"请输入你的院系：\n","院系",JOptionPane.PLAIN_MESSAGE,null,
				null,"在这输入");  
//		System.out.println("请输入密码：");
		String firstPassword=(String)JOptionPane.showInputDialog(null,
				"请输入你的密码：\n","密码",JOptionPane.PLAIN_MESSAGE,null,
				null,"在这输入");  
//		System.out.println("请再次输入密码：");
		String secondPassword=(String)JOptionPane.showInputDialog(null,
				"请再次输入密码：\n","再次输入密码",JOptionPane.PLAIN_MESSAGE,
				null,null,"在这输入");  
		StudentBiz sc = new StudentBiz();
		sc.register(studentNo, 
				studentName, 
				studentGender, 
				studentAge, 
				studentDepartment, 
				firstPassword, 
				secondPassword);
	}
}
