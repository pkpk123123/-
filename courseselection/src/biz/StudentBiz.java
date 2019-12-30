package biz;

import javax.swing.JOptionPane;

import dao.StudentDao;
import entity.IEntity;
import entity.Student;
import view.MainUI;

public class StudentBiz {
	StudentDao studentDao;
	private Student student;
	//��¼
	public void login(String studentNo, String studentPassword) throws Exception{

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			JOptionPane.showMessageDialog(null, "�û�������");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			JOptionPane.showMessageDialog(null, "��½�ɹ�");
			MainUI.setLogin(student);
		} else {
			JOptionPane.showMessageDialog(null, "�������");
		}

	}
	//ע�ᣬҵ���߼�ʵ��
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
			JOptionPane.showMessageDialog(null, "ע��ɹ�");
		}else {
			
		}
	}
	//�޸�����
	public void modifyPassword(String PrePassword,String PasswordNow,String PasswordNow2) throws Exception{
		studentDao = StudentDao.getInstance();
		student=MainUI.whoLogin();
		if (student==null) {
			JOptionPane.showMessageDialog(null, "�û���δ��¼");
			return;
		}else if (student.getStudentPassword().equals(PrePassword)) {
			if(PasswordNow.equals(PasswordNow2)==false){
				JOptionPane.showMessageDialog(null, "���벻һ��");
			}else{
				student.setStudentPassword(PasswordNow);
				studentDao.update(student);
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			}
		} else {
			JOptionPane.showMessageDialog(null, "�������");
		}
	}
	//��ӡ��ǰ��¼ѧ����Ϣ
	public void printStudentMessage(){
		student=MainUI.whoLogin();
		JOptionPane.showMessageDialog(null, "����:"+student.getStudentName()+
				"\n�Ա�:"+student.getStudentGender()+
				"\n����:"+student.getStudentAge()+
				"\nԺϵ:"+student.getStudentDepartment()+
				"\nѧ��:"+student.getStudentNo()
		, "ѧ����Ϣ", JOptionPane.OK_CANCEL_OPTION);
	}
}
