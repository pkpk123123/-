package �ھ�����ҵ;

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
		System.out.println("������ѧ������Ϣ��");
		System.out.println("������������");
		String name2=in.next();
		System.out.println("������ѧ�ţ�");
		String idnum2=in.next();
		System.out.println("���������䣺");
		int age2=in.nextInt();
		System.out.println("������绰���룺");
		String tel2=in.next();
		System.out.println("�������Ա�");
		String sex2=in.next();
		Stu[numStudent++]=new Student(name2, idnum2, age2, tel2, sex2);
		System.out.println("�����ɹ���");
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
					System.out.println("�ó�Ա����ϢΪ��");
					System.out.println("������"+Stu[i].getName()+"ѧ��:"+Stu[i].getIdnum()+"�ֻ���:"+Stu[i].getTel());
					t=-1;
					break;
				}
			}
			if(t==1)System.out.println("�ó�Ա������");
		}else if(t==2){
			System.out.println("input idnum");
			String str2=in.next();
			for(int i=0;i<numStudent;i++){
				if(Stu[i].getIdnum().equals(str2)){
					System.out.println("�ó�Ա����ϢΪ��");
					System.out.println("������"+Stu[i].getName()+"ѧ��:"+Stu[i].getIdnum()+"�ֻ���:"+Stu[i].getTel());
					t=-1;
					break;
				}
			}
			if(t==2)System.out.println("�ó�Ա������");
		}else if(t==3){
			System.out.println("input tel");
			String str2=in.next();
			for(int i=0;i<numStudent;i++){
				if(Stu[i].getName().equals(str2)){
					System.out.println("�ó�Ա����ϢΪ��");
					System.out.println("������"+Stu[i].getName()+"ѧ��:"+Stu[i].getIdnum()+"�ֻ���:"+Stu[i].getTel());
					t=-1;
					break;
				}
			}
			if(t==1)System.out.println("�ó�Ա������");
		}
	}
}