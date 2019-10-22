public class Test {
    public static void main(String[] args) {
		Taxi ti=new Taxi();
		new Thread(ti,"taxi1").start();
		new Thread(ti,"taxi2").start();
		new Thread(ti,"taxi3").start();
		new Thread(ti,"taxi4").start();
		new Thread(ti,"taxi5").start();
	}
}
class Taxi implements Runnable{
	private int people=100;
	public void run() {
		while (true) {
			if(people>0) {
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"正在发售第"+people--+"张票");
			}
		}
	}
}
