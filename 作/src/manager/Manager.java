package guanli;


import java.util.*;

public class Manager {

    static List<Student> StudentList = new LinkedList<Student>();
    public static void main(String[] agrs){

        select(StudentList);        

    }



    private static void select(List<Student> StudentList ){
        System.out.println("***************");
        System.out.println("*欢迎来到学生管理系统 *");
        System.out.println("*1：增加学生                    *");
        System.out.println("*2：删除学生                    *");
        System.out.println("*3：修改年龄                    *");
        System.out.println("*4：查询年龄                   *");
        System.out.println("*5：遍历信息                    *");

        System.out.println("***************");

        System.out.println("您想选择的操作是：");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();        
        switch(choice){
        //增加学生
        case 1:
            System.out.print("请输入学生的学号：");
            Scanner SId = new Scanner(System.in);
            String tempstudentId = SId.nextLine();
            int studentId=Integer.parseInt(tempstudentId);


            System.out.print("请输入学生的姓名：");
            Scanner Sname = new Scanner(System.in);
            String name = Sname.nextLine();

            System.out.print("请输入学生的年龄：");
            Scanner Sage = new Scanner(System.in);
            int age = Sage.nextInt();
            StudentList.add(new Student(studentId,name,age));
            System.out.println("添加成功！！！！！");
            select(StudentList);
            break;
        //删除学生成绩
        case 2:
            System.out.print("请告诉我需要删除学生的学号：");
            Scanner Sid = new Scanner(System.in);
            String SstudentId = Sid.nextLine();
            int sid=Integer.parseInt(SstudentId);
            boolean isfindDelete = false;
            for (int i = 0; i < StudentList.size(); i++) {
                if(sid==StudentList.get(i).getId()){
                    System.out.println("发现了该学生，正在删除...");
                    StudentList.remove(i);
                    System.out.println("删除成功!!!");
                    isfindDelete =true;
                }
            }
            if(!isfindDelete){
                System.out.println("抱歉，没有找到");
            }
            select(StudentList);
            break;
        //修改学生年龄
        case 3:
            System.out.print("请告诉我需要修改成绩学生的学号：");
            Scanner GId = new Scanner(System.in);
            String GstudentId = GId.nextLine();
            boolean isfindChange = false;
            for (int j = 0; j < StudentList.size(); j++) {
                if(Integer.parseInt(GstudentId)==StudentList.get(j).getId()){
                    System.out.println("发现了该学生，正在修改...");
                    System.out.println("学生年龄为"+StudentList.get(j).getAge());
                    System.out.print("请输入修改后学生的年龄：");
                    Scanner Ggrade = new Scanner(System.in);
                    int grade2 = Ggrade.nextInt();
                    StudentList.get(j).setAge(grade2);
                    System.out.println("修改成功!!!");
                    isfindChange =true;
                }else{

                }
            }
            if(!isfindChange){
                System.out.println("抱歉，没有找到");
            }
            select(StudentList);
            break;
        //查看学生成绩
        case 4:
            System.out.print("请告诉我需要查询学生的学号：");
            Scanner CId = new Scanner(System.in);
            String CstudentId = CId.nextLine();
            boolean isfindData = false;
            for (int i = 0; i < StudentList.size(); i++) {
                if(Integer.parseInt(CstudentId)==(StudentList.get(i).getId())){
                    System.out.println("学号:"+StudentList.get(i).getId());
                    System.out.println("名字:"+StudentList.get(i).getName());
                    System.out.println("年龄:"+StudentList.get(i).getAge());
                    isfindData = true;

                }
            }
            if(!isfindData){
            System.out.println("抱歉，没有找到");
            }
            select(StudentList);
            break;
        case 5:     
            for(int i=0;i<StudentList.size();i++){
                 System.out.println("学号:"+StudentList.get(i).getId());
                 System.out.println("名字:"+StudentList.get(i).getName());
                 System.out.println("年龄:"+StudentList.get(i).getAge());
            }
            select(StudentList);
            break;

        default:
            System.out.println("您输入的数字有误，请重新输入：");
            break;
        }

    }
}
