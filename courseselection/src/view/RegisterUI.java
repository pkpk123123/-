package view;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

import biz.StudentBiz;
import dao.StudentDao;

public class RegisterUI {

	public static void show() throws Exception{
//		System.out.println("������ѧ�ţ�");
		String studentNo=(String)JOptionPane.showInputDialog(null,"���������ѧ�ţ�\n","ѧ��",
				JOptionPane.PLAIN_MESSAGE,null,null,"��������");  
//		System.out.println("������������");
		String studentName =(String)JOptionPane.showInputDialog(null,"���������������\n",
				"����",JOptionPane.PLAIN_MESSAGE,null,null,"��������");  
//		System.out.println("�������Ա�");
		Object[] possibleValues = { "δѡ��", "��", "Ů" }; 
		String studentGender = (String)JOptionPane.showInputDialog(null, "��ѡ�������Ա�", "��ѡ��?", 
				JOptionPane.INFORMATION_MESSAGE, null,  possibleValues, possibleValues[0]);
//		System.out.println("���������䣺");
		int studentAge = Integer.parseInt((String)JOptionPane.showInputDialog(null,
				"������������䣺\n","����",JOptionPane.PLAIN_MESSAGE,null,
				null,"��������"));		
//		System.out.println("������Ժϵ��");
		String studentDepartment =(String)JOptionPane.showInputDialog(null,
				"���������Ժϵ��\n","Ժϵ",JOptionPane.PLAIN_MESSAGE,null,
				null,"��������");  
//		System.out.println("���������룺");
		String firstPassword=(String)JOptionPane.showInputDialog(null,
				"������������룺\n","����",JOptionPane.PLAIN_MESSAGE,null,
				null,"��������");  
//		System.out.println("���ٴ��������룺");
		String secondPassword=(String)JOptionPane.showInputDialog(null,
				"���ٴ��������룺\n","�ٴ���������",JOptionPane.PLAIN_MESSAGE,
				null,null,"��������");  
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
