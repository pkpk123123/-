package dao;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import entity.*;

public class SCDao implements IDao {
	private static SCDao instance=null;
	private HashMap<String, SC> scs;
	private SC sc;
	
	private SCDao() throws Exception{
		scs = new HashMap<String, SC>();
		sc = new SC();
		FileInputStream in=null;
		try{
			in=new FileInputStream("message\\scSrc.txt");
		}catch (Exception e){
		}
		InputStreamReader isr=new InputStreamReader(in);
		BufferedReader br=new BufferedReader(isr);
		String line;
		while((line=br.readLine())!=null){
			String []Mess=line.split(";");
			for(String str:Mess){
				String []mess=str.split(",");
				sc = new SC();
				sc.setStudentNo(mess[0]);
				String courseNo[]=mess[1].split("\\|");
				for(String t:courseNo){
						sc.addCourseNo(t);
//						System.out.println(t);
				}
				sc.addGrade(Integer.parseInt(mess[2]));
				scs.put(sc.getStudentNo(), sc);
				}	
			}
		br.close();
	}
	public static SCDao getInstance() throws Exception{
		if(instance == null) {
			synchronized(SCDao.class) {
				if(instance == null) {
					instance = new SCDao();
					return instance;
				}
			}
		}
		return instance;
	}
	@Override
	public void insert(IEntity entity) {
		sc=(SC)entity;
		scs.put(sc.getStudentNo(), sc);
		this.save();
	}

	@Override
	public void delete(IEntity entity) {
		// TODO Auto-generated method stub
		String StudentNo=((Student)entity).getStudentNo();
		scs.remove(StudentNo);
		this.save();
	}

	@Override
	public void update(IEntity entity) {
		// TODO Auto-generated method stub
		sc=(SC)entity;
		scs.put(sc.getStudentNo(), sc);
		this.save();
	}

	public HashMap<String, SC> getAllEntities() {
		// TODO Auto-generated method stub
		return scs;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return scs.get(Id);
	}
	public void save(){
		FileWriter writer=null;
		try{
			writer=new FileWriter("message\\scSrc.txt");
		}catch (Exception e){}
		Set keySet=scs.keySet();
		Iterator it=keySet.iterator();
		SC tmp;
		String str,ans="";
		while(it.hasNext()){
			Object key=it.next();
			tmp=(SC)scs.get((String)key);
			str=tmp.getStudentNo()+",";
			TreeSet<String> courseNoSet=tmp.getAllCourseNo();
			for(String t:courseNoSet){
				str+=t+"|";
			}
			str+=","+tmp.getGrade();
			ans=ans+str+";";
		}
		try{
			writer.write(ans);
			writer.close();
		}catch(Exception e){};
	}

}
