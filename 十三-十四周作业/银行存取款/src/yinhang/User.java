package yinhang;

/*�û�����Ϣ*/
public class User {
	private String cardId;   //���п���
	private String cardPwd;  //���п�����
	private String UserName;  //�˻���
	private String call;  //�ֻ�����
	private int account;  //����
	public String getCardId(){
		return cardId;
	}
	public void setCardId(String cardId){
		this.cardId = cardId;
	}
	public String getCardPwd(){
		return cardPwd;
	}
	public void setCardPwd(String cardPwd){
		this.cardPwd = cardPwd;
	}
	public String getUserName(){
		return UserName;
	}
	public void setUserName(String userName){
		this.UserName = userName;
	}
	public String getCall(){
		return call;
	}
	public void setCall(String call){
		this.call = call;
	}
	public int getAccount(){
		return account;
	}
	public void setAccount(int account){
		this.account = account;
	}
}
