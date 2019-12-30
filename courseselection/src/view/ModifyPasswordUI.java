package view;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;
import biz.*;

public class ModifyPasswordUI{
	
	public static void show() throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入原始密码");
		String PrePassword=(String)JOptionPane.showInputDialog(null,"请输入原始密码：\n","安师选课系统",JOptionPane.PLAIN_MESSAGE,null,null,"请输入");
		System.out.println("请输入修改后的密码");
		String PasswordNow=(String)JOptionPane.showInputDialog(null,"请输入修改后的密码：\n","安师选课系统",JOptionPane.PLAIN_MESSAGE,null,null,"请输入");
		System.out.println("请再次输入修改后的密码");
		String PasswordNow2=(String)JOptionPane.showInputDialog(null,"请再次输入修改后的密码：\n","安师选课系统",JOptionPane.PLAIN_MESSAGE,null,null,"请输入");
		StudentBiz sc = new StudentBiz();
		sc.modifyPassword(PrePassword, PasswordNow, PasswordNow2);
	}
}
