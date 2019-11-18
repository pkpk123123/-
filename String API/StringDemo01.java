public class StringDemo01 {
    public static void main(String[] args) {
        //public String()：空构造
        String str1 = new String();
        System.out.println("str1:"+str1);
        System.out.println("str1.length:"+str1.length());
        System.out.println("----------------------------");
        //public String(byte[] bytes)：把字节数组转成字符串
        byte[] bys = {97,98,99,100,126};
        String str2 = new String(bys);
        System.out.println("str2:"+str2);
        System.out.println("str2.length:"+str2.length());
        System.out.println("----------------------------");
        //public String(byte[] bytes,int offset,int length)：把字节数组的一部分转成字符串
        String str3 = new String(bys,2,3);
        System.out.println("str3:"+str3);
        System.out.println("str3.length:"+str3.length());
        System.out.println("----------------------------");
        //public String(char[] value)：把字符数组转成字符串
        char[] c = {'a','b','c','爱','生','活'};
        String str4 = new String(c);
        System.out.println("str4:"+str4);
        System.out.println("str4.length:"+str4.length());
        System.out.println("----------------------------");
        //public String(char[] value,int offset,int count)：把字符数组一部分转成字符串
        String str5 = new String(c,3,3);
        System.out.println("str5:"+str5);
        System.out.println("str5.length:"+str5.length());
        System.out.println("----------------------------");
        //public String(String original)：把一个字符串常量转成字符串
        String str6 = new String("hello world");
        System.out.println("str6:"+str6);
        System.out.println("str6.length:"+str6.length());
        System.out.println("----------------------------");
        //字符串字面值"hello world"也可以看成是一个字符串对象。
        String s7 = "hello world";
        System.out.println("s7:"+s7);
        System.out.println("s7.length():"+s7.length());
    }
}