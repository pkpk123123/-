public class Down {
    public static void main(String[] args) {
		Zu ti=new Zu();
		new Thread(ti,"��1").start();
		new Thread(ti,"��2").start();
		new Thread(ti,"��3").start();
	}
}
class Zu implements Runnable{
	private int[] arr=new int[100];
	public void run() {
		for(int i=1;i<=100;i++){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"�������ص�"+i+"��");
		}
}
}