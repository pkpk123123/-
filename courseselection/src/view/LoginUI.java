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
//		System.out.println("������ѧ�ţ�");
		scanner = new Scanner(System.in);
		studentName=(String)JOptionPane.showInputDialog(null,"���������ѧ�ţ�\n","ѧ��",JOptionPane.PLAIN_MESSAGE,null,null,"��������");  
//		System.out.println("���������룺");
		studentPassword = (String)JOptionPane.showInputDialog(null,"������������룺\n","����",JOptionPane.PLAIN_MESSAGE,null,null,"��������");
		studentBiz = new StudentBiz();
		studentBiz.login(studentName, studentPassword);
	}
}
