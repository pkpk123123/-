package view;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;
import biz.*;

public class ModifyPasswordUI{
	
	public static void show() throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ԭʼ����");
		String PrePassword=(String)JOptionPane.showInputDialog(null,"������ԭʼ���룺\n","��ʦѡ��ϵͳ",JOptionPane.PLAIN_MESSAGE,null,null,"������");
		System.out.println("�������޸ĺ������");
		String PasswordNow=(String)JOptionPane.showInputDialog(null,"�������޸ĺ�����룺\n","��ʦѡ��ϵͳ",JOptionPane.PLAIN_MESSAGE,null,null,"������");
		System.out.println("���ٴ������޸ĺ������");
		String PasswordNow2=(String)JOptionPane.showInputDialog(null,"���ٴ������޸ĺ�����룺\n","��ʦѡ��ϵͳ",JOptionPane.PLAIN_MESSAGE,null,null,"������");
		StudentBiz sc = new StudentBiz();
		sc.modifyPassword(PrePassword, PasswordNow, PasswordNow2);
	}
}
