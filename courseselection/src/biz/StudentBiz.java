package biz;

import javax.swing.JOptionPane;

import dao.StudentDao;
import entity.IEntity;
import entity.Student;
import view.MainUI;

public class StudentBiz {
	StudentDao studentDao;
	private Student student;
	//登录
	public void login(String studentNo, String studentPassword) throws Exception{

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			JOptionPane.showMessageDialog(null, "用户不存在");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			JOptionPane.showMessageDialog(null, "登陆成功");
			MainUI.setLogin(student);
		} else {
			JOptionPane.showMessageDialog(null, "密码错误");
		}

	}
	//注册，业务逻辑实现
	public void register(String studentNo, 
						String studentName, 
						String studentGender, 
						int studentAge, 
						String studentDepartment, 
						String firstPassword, 
						String secondPassword) throws Exception{
		if(firstPassword.equals(secondPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentGender(studentGender);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			studentDao = StudentDao.getInstance();
			studentDao.insert(student);
			JOptionPane.showMessageDialog(null, "注册成功");
		}else {
			
		}
	}
	//修改密码
	public void modifyPassword(String PrePassword,String PasswordNow,String PasswordNow2) throws Exception{
		studentDao = StudentDao.getInstance();
		student=MainUI.whoLogin();
		if (student==null) {
			JOptionPane.showMessageDialog(null, "用户尚未登录");
			return;
		}else if (student.getStudentPassword().equals(PrePassword)) {
			if(PasswordNow.equals(PasswordNow2)==false){
				JOptionPane.showMessageDialog(null, "密码不一致");
			}else{
				student.setStudentPassword(PasswordNow);
				studentDao.update(student);
				JOptionPane.showMessageDialog(null, "修改成功");
			}
		} else {
			JOptionPane.showMessageDialog(null, "密码错误");
		}
	}
	//打印当前登录学生信息
	public void printStudentMessage(){
		student=MainUI.whoLogin();
		JOptionPane.showMessageDialog(null, "姓名:"+student.getStudentName()+
				"\n性别:"+student.getStudentGender()+
				"\n年龄:"+student.getStudentAge()+
				"\n院系:"+student.getStudentDepartment()+
				"\n学号:"+student.getStudentNo()
		, "学生信息", JOptionPane.OK_CANCEL_OPTION);
	}
}
