package biz;

import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import dao.*;
import entity.*;
import view.MainUI;

public class SCBiz {
	private SCDao scDao;
	private CourseDao courseDao;
	private SC sc;
	private Student student;
	private Course course;
	
	public void selectCourse(String courseNo)throws Exception{
		
		scDao=SCDao.getInstance();
		courseDao=CourseDao.getInstance();
		
		student=MainUI.whoLogin();
		sc=(SC)scDao.getEntity(student.getStudentNo());
		if(sc==null){
			sc=new SC();
			sc.setStudentNo(student.getStudentNo());
		}
		if(courseDao.isTrueCourseNo(courseNo)==false){
			System.out.println("�γ�id����,ѡ��ʧ��");
		}else if(sc.isSelected(courseNo)){
			System.out.println("���Ѿ�ѡ���ÿγ�!!!");
		}else{
			sc.addCourseNo(courseNo);
			sc.addGrade(((Course)(courseDao.getEntity(courseNo))).getCourseGrade());
			scDao.insert(sc);
			System.out.println("ѡ�γɹ�");
		}
	}
	public boolean printSelectedCourse()throws Exception{
		scDao=SCDao.getInstance();
		courseDao=CourseDao.getInstance();
		student=MainUI.whoLogin();
		sc=(SC)scDao.getEntity(student.getStudentNo());
		if(sc==null){
			sc=new SC();
			sc.setStudentNo(student.getStudentNo());
			scDao.insert(sc);
		}
		if(sc.isEmpty()){
			System.out.println("����δѡ����γ�,�뼰ʱѡ��");
			return false;
		}else{
			TreeSet<String> AllCourseNo=sc.getAllCourseNo();
			for(String courseNo:AllCourseNo){
				if(courseNo!=" "&&courseNo!="\\|"){
					Course cr=(Course)courseDao.getEntity(courseNo);
					if(cr==null)continue;
					
					System.out.println(cr.getCourseNo()+' '+cr.getCourseName()+' '+cr.getCourseGrade());
				}
			}
			return true;
			
		}
	}
	public void deleteOneCourse(String courseNo)throws Exception{
		scDao=SCDao.getInstance();
		courseDao=CourseDao.getInstance();
		student=MainUI.whoLogin();
		sc=(SC)scDao.getEntity(student.getStudentNo());
		if(sc==null){
			sc=new SC();
			sc.setStudentNo(student.getStudentNo());
			scDao.insert(sc);
		}
		if(sc.isEmpty()){
			System.out.println("����δѡ����γ�,�뼰ʱѡ��");
		}else{
			if(sc.isSelected(courseNo)){
				sc.deleteCourse(courseNo);
				scDao.insert(sc);
				String courseName=((Course)courseDao.getEntity(courseNo)).getCourseName();
				System.out.println("���ѳɹ���ѡ�γ�"+courseName);
			}else{
				JOptionPane.showMessageDialog(null, "����δѡ����ÿγ�"
				, "Error", 0);
			}
		}
	}
}
