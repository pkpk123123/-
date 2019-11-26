package user;

import java.util.*;

public class HaHaUser implements User{
	private String phoneNumber;
	private String callTo;
	private ArrayList commucationRecords;
	public HaHaUser(String phoneNumber){
		this.phoneNumber=phoneNumber;
		this.commucationRecords=new ArrayList();
	}
	public void generateCommucationRecord(){
		/*ArrayList�汾*/
		int recordNum=new Random().nextInt(10);
		for(int i=0;i<=recordNum;i++){
			long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
			long timeEnd=timeStart+60000+new Random().nextInt(600000);
			callTo=this.getCallToPhoneNumber();
			this.commucationRecords.add(new String(this.phoneNumber+","+timeStart+","+timeEnd+","+this.callTo+";"));
		}
	}
	public void printDetails(){
		for(int i=0;i<commucationRecords.size();i++){
			String []recordField=((String)commucationRecords.get(i)).split(",");
			System.out.println("����:"+recordField[0]);
			System.out.println("����:"+recordField[3]);
			System.out.println("ͨ����ʼʱ��:"+new Date(Long.parseLong(recordField[1])));
			System.out.println("ͨ������ʱ��:"+new Date(Long.parseLong(recordField[2])));
			System.out.println("�Ʒ�:"+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))+"Ԫ");
		}
	}
	public String getCallToPhoneNumber(){
			return "1765631"+String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10));
	}
	public String accountFee(long timeStart,long timeEnd){
		double feePerMinute=50;
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=feePerMinute*minutes;
		return String.format("%.4f",feeTotal);
	}
	
}