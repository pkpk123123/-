class Person {
	void say() {            // 创建say()方法，输出一句话
		System.out.println("我是一个人!");
	}
}
public class Example02 {
	public static void main(String[] args) {
		Person p2 = new Person();  // 创建Person对象
		p2.say();                     // 调用say()方法
		p2 = null;                    // 将Person对象置为null
		p2.say();
	}
}
