package Tel;
import java.text.*;
import java.util.*;
import xml.ReadXMLUitilcar;
import company.*;
import name.*;
public class TelcomUser {
     private String PhoneNumber;
     private String callTo;
     private ArrayList  list;
     private HashMap singleRecord;
     public TelcomUser(String phoneNumber) {
    	 this.PhoneNumber =phoneNumber;
    	 this.list=new ArrayList();
     }
//ģ��ͨ����¼������
public void generateCommunicateRcords() {
    	 int recordNum=new Random().nextInt(10);
    	 for(int i=0;i<=recordNum;i++) {
    		 //������ɵ�i��ͨ����¼
    		 //��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ�����ʱ��
    		 long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
    		 //����ʱ�俪ʼ���ʮ�����������һ��ʱ�䣬����һ����
    		 long timeEnd=timeStart + 60000+new Random().nextInt(600000);
    		 //���к���
    		 this.callTo=getCallToPhoneNumber(); 
    		 //����ͨ����¼
    		 this.singleRecord =new HashMap();
    		 this.singleRecord.put("����", this.PhoneNumber);
    		 this.singleRecord.put("��ʼʱ��",new Date(timeStart));
    		 this.singleRecord.put("����ʱ��",new Date(timeEnd));
    		 this.singleRecord.put("���к���",this.callTo);
    		 this.singleRecord.put("�Ʒ�",this.accountFee(timeStart, timeEnd));
    		 this.list.add(this.singleRecord);
    	 }	 
     }
     //������ɱ��к��루����λ�����������
     private String getCallToPhoneNumber(){
    	 return "1834844"+String.valueOf( new Random().nextInt(10))+
    			 String.valueOf( new Random().nextInt(10))+
    			 String.valueOf(new Random().nextInt(10))+
    			 String.valueOf(new Random().nextInt(10));
    			 
     }
//ģ��ƷѰ취�����ַ�������ʽ���ر���4λС���ļƷѽ��
private String accountFee(long timeStart, long timeEnd) { 	
	Dianxin  ch = null;
	Company company;
	ch=(Dianxin)ReadXMLUitilcar.getBean();
	company=ch.productCompany();
    		 //ÿ�����շ�*Ԫ
    		 double feePerMinute=company.fei();
    		 //ͨ������ȥβ
    		 int minutes=Math.round((timeEnd-timeStart)/60000);
    		 double feeTotal=feePerMinute * minutes;
    		 return String.format("%a.4f", feeTotal);
    	 }
//��ӡͨ����¼
public void printDetails() { 
	    Iterator it=this.list.iterator();
    	 //ѭ���ָ��¼�ڵ�ÿһ����
    	 while(it.hasNext()){    
    		 System.out.println("--------ͨ����¼������---------------");
    		 this.singleRecord = ((HashMap)it.next());
    		 Set keySet = this.singleRecord.keySet();
    		 Iterator itKey = keySet.iterator();
    		 while(itKey.hasNext()) {
    			 Object key = itKey.next();
    			 Object value = this.singleRecord.get(key);
    			 System.out.println(key + ":" + value);
    		 }
    	 }
    }
a

//������ʽ����ʹ��entrySet����
 /*public void printDetails() { 
	    Iterator it=this.list.iterator();
    	 while(it.hasNext()){    
    		 System.out.println("--------ͨ����¼������---------------");
    		 this.singleRecord = ((HashMap)it.next());
    		 Set entrySet = this.singleRecord.entrySet();
    		 Iterator itEntry = entrySet.iterator();
    		 while(itEntry.hasNext()) {
    		    Map.Entry entry = (Map.Entry)itEntry.next();
    			 Object key = entry.getKey();
    			 Object value = entry.getValue();
    			 System.out.println(key + ":" + value);
    		 }
    	 }
    }*/
 
}
