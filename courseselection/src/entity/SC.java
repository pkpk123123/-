package entity;

import java.util.TreeSet;

public class SC implements IEntity {
	private String studentNo;
	private TreeSet<String> courseNoSelected;
	private int grade;
	public SC(){
		courseNoSelected=new TreeSet<String>();
		grade=0;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public boolean isSelected(String courseNo){
		if(courseNoSelected.contains(courseNo)){
			return true;
		}
		return false;
	}
	public void addCourseNo(String courseNo) {
		courseNoSelected.add(courseNo);
	}
	public TreeSet<String> getAllCourseNo(){
		return this.courseNoSelected;
	}
	public boolean isEmpty(){
		if(courseNoSelected.isEmpty()){
			return true;
		}
		return false;
	}
	public int getGrade() {
		return grade;
	}
	public void addGrade(int grade) {
		this.grade += grade;
	}
	public void deleteCourse(String courseNo){
		this.courseNoSelected.remove(courseNo);
	}
}
