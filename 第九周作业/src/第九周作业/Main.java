package 第九周作业;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		for(;;){
			Student.AddStudent();
			System.out.println("是否继续添加？Y/N");
			String isCreate=in.next();
			while(!isCreate.equals("Y")&&!isCreate.equals("N")){
				System.out.println("输入错误，请重新输入");
				isCreate=in.next();
			}
			while(isCreate.equals("N")){
				System.out.println("请输入你要执行的选项：");
				System.out.println("1.changeName");
				System.out.println("2.changeIdnum");
				System.out.println("3.changeAge");
				System.out.println("4.changeTel");
				System.out.println("5.changeSex");
				System.out.println("6.find");
				System.out.println("7.breaktoAddNewStudent");
				int t=in.nextInt();
				while(t<0||t>7){
					System.out.println("输入的选项有误，请重新输入：");
					t=in.nextInt();
				}
				switch(t){
				case 1:
					System.out.println("please input your name");
					String tmp=in.next();
					Student.Stu[Student.numStudent-1].changeName(tmp);
					break;
				case 2:
					System.out.println("please input your Idnumber");
					String tmp2=in.next();
					Student.Stu[Student.numStudent-1].changeIdnum(tmp2);
					break;
				case 3:
					System.out.println("please input your age");
					int tmp3=in.nextInt();
					Student.Stu[Student.numStudent-1].changeAge(tmp3);
					break;
				case 4:
					System.out.println("please input your Tel");
					String tmp4=in.next();
					Student.Stu[Student.numStudent-1].changeTel(tmp4);
					break;
				case 5:
					System.out.println("please input your sex");
					String tmp5=in.next();
					Student.Stu[Student.numStudent-1].changeSex(tmp5);
					break;
				case 6:
					Student.find();
					break;
				case 7:
					isCreate="Y";
				}
			}
		}
	}
}
