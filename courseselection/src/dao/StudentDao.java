package dao;
import entity.IEntity;
import entity.Student;
import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StudentDao implements IDao {

	private static StudentDao instance;
	private HashMap<String, Student> students;
	private Student student;
	private StudentDao() throws Exception{
		students = new HashMap<String, Student>();
		student = new Student();
		FileInputStream in=null;
		try{
			in=new FileInputStream("message\\stuentSrc.txt");
		}catch (Exception e){
		}
		InputStreamReader isr=new InputStreamReader(in);
		BufferedReader br=new BufferedReader(isr);
		String line;
		while((line=br.readLine())!=null){
			String []Mess=line.split(";");
			for(String str:Mess){
				String []mess=str.split(",");
				student = new Student();
				student.setStudentNo(mess[0]);
				student.setStudentName(mess[1]);
				student.setStudentGender(mess[2]);
				student.setStudentPassword(mess[3]);
				student.setStudentAge(Integer.parseInt(mess[4]));
				student.setStudentDepartment(mess[5]);
				students.put(student.getStudentNo(), student);
				}	
			}
		br.close();
	}
	public static StudentDao getInstance() throws Exception{
		if(instance == null) {
			synchronized(StudentDao.class) {
				if(instance == null) {
					instance = new StudentDao();
					return instance;
				}
			}
		}
		return instance;
	}
	@Override
	public void insert(IEntity entity) throws Exception{
		// TODO Auto-generated method stub
		Student st = (Student)entity;
		students.put(st.getStudentNo(), st);
//		System.out.println(st.getStudentNo());
		this.save();
	}

	@Override
	public void delete(IEntity entity) throws Exception{
		// TODO Auto-generated method stub
		Student st=(Student)entity;
		students.remove(st.getStudentNo());
		this.save();
	}

	@Override
	public void update(IEntity entity) throws Exception{
		// TODO Auto-generated method stub
		Student st = (Student)entity;
		students.put(st.getStudentNo(), st);
		this.save();
	}

	public HashMap<String, Student> getAllEntities() {
		// TODO Auto-generated method stub
		return students;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return students.get(Id);
	}

	public void save() throws Exception{
		FileWriter writer=null;
		writer=new FileWriter("message\\stuentSrc.txt");
		String str;
		Set keySet=students.keySet();
		Iterator it=keySet.iterator();
		Student tmp;
		String ans="";
		while(it.hasNext()){
			Object key=it.next();
			System.out.println((String)key);
			
			tmp=(Student)students.get((String)key);
			str=tmp.getStudentNo()+","+tmp.getStudentName()+","+tmp.getStudentGender()+","+tmp.getStudentPassword()+","+tmp.getStudentAge()+","+tmp.getStudentDepartment();
			tmp=null;
			System.out.println(str);
			ans=ans+str+";";
		}
		writer.write(ans);
		writer.close();
	}
}
