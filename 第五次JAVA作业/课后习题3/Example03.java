public class Example03 {
    public static void main(String[] args) {
		Teacher ti=new Teacher();
		new Thread(ti,"��ʦ1").start();
		new Thread(ti,"��ʦ2").start();
		new Thread(ti,"��ʦ3").start();
	}
}
class Teacher implements Runnable{
	public void run() {
		for(int i=1;i<=80;i++){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"���ڷ��ŵ�"+i+"����ҵ");
		}
}
}