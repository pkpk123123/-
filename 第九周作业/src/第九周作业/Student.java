package 第九周作业;

import java.util.Scanner;

public class Student {
	static Scanner in=new Scanner(System.in);
	static int numStudent;
	static Student Stu[]=new Student[5000];
	private String name;
	private String idnum;
	private int age;
	private int age;
	private String tel;
	private String sex;
	Student(){};
	Student(String name,String idnum,int age,String tel,String sex){
		this.name=name;
		this.idnum=idnum;
		this.age=age;
		this.tel=tel;
		this.sex=sex;
	};
	public static void AddStudent(){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入学生的信息：");
		System.out.println("请输入姓名：");
		String name2=in.next();
		System.out.println("请输入学号：");
		String idnum2=in.next();
		System.out.println("请输入年龄：");
		int age2=in.nextInt();
		System.out.println("请输入电话号码：");
		String tel2=in.next();
		System.out.println("请输入性别：");
		String sex2=in.next();
		Stu[numStudent++]=new Student(name2, idnum2, age2, tel2, sex2);
		System.out.println("创建成功！");
	}
	public void changeName(String name){
		this.name=name;
		System.out.println("Successfully!");
	}
	public void changeIdnum(String idnum){
		this.idnum=idnum;
		System.out.println("Successfully!");
	}
	public void changeAge(int age){
		this.age=age;
		System.out.println("Successfully!");
	}
	public void changeTel(String tel){
		this.tel=tel;
		System.out.println("Successfully!");
	}
	public void changeSex(String sex){
		this.sex=sex;
		System.out.println("Successfully!");
	}
	public String getName(){
		return name;
	}
	public String getTel(){
		return tel;
	}
	public String getIdnum(){
		return idnum;
	}
	public static void find(){
		System.out.println("1.find information by name");
		System.out.println("2.find information by idnum");
		System.out.println("3.find information by tel");
		int t=in.nextInt();
		if(t==1){
			System.out.println("input name");
			String str2=in.next();
			for(int i=0;i<numStudent;i++){
				if(Stu[i].getName().equals(str2)){
					System.out.println("该成员的信息为：");
					System.out.println("姓名："+Stu[i].getName()+"学号:"+Stu[i].getIdnum()+"手机号:"+Stu[i].getTel());
					t=-1;
					break;
				}
			}
			if(t==1)System.out.println("该成员不存在");
		}else if(t==2){
			System.out.println("input idnum");
			String str2=in.next();
			for(int i=0;i<numStudent;i++){
				if(Stu[i].getIdnum().equals(str2)){
					System.out.println("该成员的信息为：");
					System.out.println("姓名："+Stu[i].getName()+"学号:"+Stu[i].getIdnum()+"手机号:"+Stu[i].getTel());
					t=-1;
					break;
				}
			}
			if(t==2)System.out.println("该成员不存在");
		}else if(t==3){
			System.out.println("input tel");
			String str2=in.next();
			for(int i=0;i<numStudent;i++){
				if(Stu[i].getName().equals(str2)){
					System.out.println("该成员的信息为：");
					System.out.println("姓名："+Stu[i].getName()+"学号:"+Stu[i].getIdnum()+"手机号:"+Stu[i].getTel());
					t=-1;
					break;
				}
			}
			if(t==1)System.out.println("该成员不存在");
		}
	}
}