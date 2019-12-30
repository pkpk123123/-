package dao;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import entity.*;

public class CourseDao implements IDao {
	private static CourseDao instance;
	private HashMap<String, Course> courses;
	private Course course;
	private CourseDao() throws Exception{
		courses = new HashMap<String, Course>();
		course = new Course();
		FileInputStream in=null;
		in=new FileInputStream("message\\courseSrc.txt");
		InputStreamReader isr=new InputStreamReader(in);
		BufferedReader br=new BufferedReader(isr);
		String line;
		while((line=br.readLine())!=null){
			String []Mess=line.split(";");
			for(String str:Mess){
				course = new Course();
				String []mess=str.split(",");
				course.setCourseNo(mess[0]);
				course.setCourseName(mess[1]);
				course.setCourseGrade(Integer.parseInt(mess[2]));
				courses.put(mess[0], course);
			}	
		}
		br.close();
	}
	public static CourseDao getInstance() throws Exception{
		if(instance == null) {
			synchronized(CourseDao.class) {
				if(instance == null) {
					instance = new CourseDao();
					return instance;
				}
			}
		}
		return instance;
	}
	public boolean isTrueCourseNo(String courseNo){
		if(courses.containsKey(courseNo)){
			return true;
		}
		return false;
	}
	public void printAll()throws Exception{
		Collection values=this.courses.values();
		Iterator it=values.iterator();
		while(it.hasNext()){
			Course value=(Course)it.next();
			System.out.println(value.getCourseNo()+' '+value.getCourseName()+' '+value.getCourseGrade());
		}
		
	}
	@Override
	public void insert(IEntity entity) throws Exception{
		// TODO Auto-generated method stub
		Course cr = (Course)entity;
		courses.put(cr.getCourseNo(), cr);
	}

	@Override
	public void delete(IEntity entity) throws Exception{
		// TODO Auto-generated method stub
		course=(Course)entity;
		courses.remove(course.getCourseNo());
	}

	@Override
	public void update(IEntity entity) throws Exception{
		course=(Course)entity;
		courses.put(course.getCourseNo(),course);
	}

	public HashMap<String, Course> getAllEntities() {
		return courses;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return courses.get(Id);
	}
	
	public void save(){
		FileWriter writer=null;
		try{
			writer=new FileWriter("message\\courseSrc.txt");
		}catch (Exception e){}
		String str,ans="";
		Set keySet=courses.keySet();
		Iterator it=keySet.iterator();
		Course tmp;
		while(it.hasNext()){
			Object key=it.next();
			tmp=(Course)courses.get((String)key);
			str=tmp.getCourseNo()+","+tmp.getCourseName()+","+tmp.getCourseGrade();
			ans=ans+str+";";
		}
		try{
			writer.write(ans);
			writer.close();
		}catch(Exception e){};
	}

}
