public class Example01 {
	public static void main(String[] args) {
		MyThread ti=new MyThread();
                                new Thread(ti,"����").start();
		new Thread(ti,"����").start();
	}
}
class MyThread extends Thread{
	public void run() {
		Thread th=Thread.currentThread();
		String th_name=th.getName();
		System.out.println(th_name);
	}
}