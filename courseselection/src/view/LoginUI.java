package view;

import java.util.Scanner;
import javax.swing.*;
import biz.StudentBiz;

public class LoginUI {	

	public static void show() throws Exception{
		Scanner scanner;
		String studentName;
		String studentPassword;
		StudentBiz studentBiz;
//		System.out.println("请输入学号：");
		scanner = new Scanner(System.in);
		studentName=(String)JOptionPane.showInputDialog(null,"请输入你的学号：\n","学号",JOptionPane.PLAIN_MESSAGE,null,null,"在这输入");  
//		System.out.println("请输入密码：");
		studentPassword = (String)JOptionPane.showInputDialog(null,"请输入你的密码：\n","密码",JOptionPane.PLAIN_MESSAGE,null,null,"在这输入");
		studentBiz = new StudentBiz();
		studentBiz.login(studentName, studentPassword);
	}
}
