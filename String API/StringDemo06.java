public class StringDemo06{
    public static void main(String[] args) {
        // 定义用户名和密码。已存在的。
        String username = "admin";
        String password = "admin";
        // 给三次机会，用循环改进，最好用for循环。
        for(int x = 0; x < 3; x++){
            // 键盘录入用户名和密码。
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String name = sc.nextLine();
            System.out.println("请输入密码：");
            String pwd = sc.nextLine();
            if (name.equals(username) && pwd.equals(password)){
                System.out.println("登陆成功，开始玩猜数字游戏.");
                //猜数字游戏
                GuessNumberGame.start();
                break;
            }else{
                  if ((2-x) == 0){
                      System.out.println("账号已冻结，请与管理员联系");
                  }else{
                      System.out.println("登陆失败，你还有"+(2-x)+"次机会");
                  }
            }
        }
    }
}