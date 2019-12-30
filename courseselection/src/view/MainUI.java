package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class MainUI {
	private static entity.Student LoginedUser=null;
	public static  entity.Student whoLogin(){
		return LoginedUser;
	}
	public static void setLogin(entity.Student User){
		LoginedUser=User;
	}
	public static boolean isLogin(){
		if(LoginedUser==null){
			JOptionPane.showMessageDialog(null, "您还未登陆", "错误", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	public static void show() throws Exception{
		Frame f=new Frame("学生选课系统");
		f.setSize(1200,600);
		f.setLocation(350, 170);
		f.setFont(new Font("宋体",Font.BOLD,30));
		Button btn1=new Button("注册");
		btn1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try{RegisterUI.show();}catch(Exception a){};
			}
		});
		Button btn2=new Button("修改密码");
		btn2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(isLogin())
				try{ModifyPasswordUI.show();}catch(Exception a){};
			}
		});
		Button btn3=new Button("选课");
		btn3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(isLogin())
					try{CourseSelection.show();}catch(Exception a){};
			}
		});
		Button btn4=new Button("登录");
		btn4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try{LoginUI.show();}catch(Exception a){};
			}
		});
		Button btn5=new Button("个人信息");
		btn5.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				if(isLogin())
				try{Message.show();}catch(Exception a){};
			}
		});
		btn1.setBackground(new Color(135,206,235));
		btn1.setBounds(70,450,150,70);
		btn2.setBackground(new Color(135,206,235));
		btn2.setBounds(370,450,150,70);
		btn3.setBackground(new Color(135,206,235));
		btn3.setBounds(670,450,150,70);
		btn4.setBackground(Color.PINK);
		btn4.setBounds(490,230,200,100);
		btn5.setBackground(new Color(135,206,235));
		btn5.setBounds(970,450,150,70);
		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);
		f.add(btn5);
		String bgpath = ".\\background\\bg.jpg";
		ImageIcon background = new ImageIcon(bgpath);
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, f.getWidth(), f.getHeight());
		f.add(label);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				f.dispose();
			}
		});
		f.setVisible(true);
	}
}
