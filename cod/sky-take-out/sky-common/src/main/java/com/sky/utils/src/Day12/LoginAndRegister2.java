package Day12;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//黑马改进的版本：
//加入打印功能，重构内部代码
public class LoginAndRegister2 {
    //静态方法只能调用静态的成员变量！
    //初始化变量尽量使用static修饰符与静态代码块初始化。
    static ArrayList<User> list = new ArrayList<>();
    static {
        list.add(new User("zhangsan", "123456", "888888888888888888", "18888888888"));
        list.add(new User("lisi", "654321", "430945222245647891", "18888888889"));
        list.add(new User("wangwu", "12345678", "430945222245647892", "18888888880"));
        list.add(new User("zhaoliu", "87654321", "430945222245647893", "18888888881"));
    }
    public static void main(String[] args) {
        System.out.println("-------------欢迎来到黑马学生管理系统----------------");
        printList(list);
        loop:
        while (true) {
            System.out.println("请选择操作  1登录  2注册  3忘记密码 4退出");
            Scanner scanner = new Scanner(System.in);
            try {
                int i = scanner.nextInt();
                switch (i) {
                    case 1 -> {
                        if (login(list)) break loop;
                    }
                    case 2 -> register(list);
                    case 3 -> forgetPassword(list);
                    case 4 -> {
                        //这里用System.exit(0)也行，chatGPT说用return好一点：
                        //在Java中结束主方法建议使用return，而不是System.exit(0)。
                        //原因是System.exit(0)会直接退出JVM，而不管正在进行的线程是否已经完成，这可能会产生不可预料的结果，比如有些数据还没有被写回文件，或者数据库连接还没有关闭。
                        //相比之下，return 会让当前线程返回到调用点，JVM 会在所有线程都执行完毕之后自动退出，确保程序可以正常结束而不会导致不必要的问题。
                        System.out.println("欢迎再来");
                        return;
                    }
                    default -> System.out.println("没有这个选项");
                }
            } catch (Exception e) {
                System.out.println("输入错误！");
            }
        }
        System.out.println("欢迎用户登录！");
    }

    //选项:注册
    private static void register(ArrayList<User> list) {
        System.out.println("欢迎注册");
        String username, password, ID, phoneNumber;
        Scanner scanner = new Scanner(System.in);
        //在先前的做法中我的username是直接通过方法来得到的。
        //但是老师的做法是通过方法检查username那么是否正确，在这个方法中来录入数。
        //先前的做法当中，每一个方法里面都要写scanner，还是老师的方法更好。
        //用户名输入与检测，下面四个部分的检测基本上都是if else的逻辑，输入正确停止循环，密码的输入稍微有些不一样（因为那个模块比较简单）
        while (true) {
            System.out.println("请输入用户名（3-15位字母加数字且不能为纯数字）：");
            username = scanner.next();
            if (!checkUsername(username)) {
                continue;
            }
            if (contains(list, username)) {
                System.out.println("已存在该用户名");
                continue;
            }
            break;
        }
        //密码的输入与检测
        while (true) {
            System.out.println("请输入用密码两次：");
            password = scanner.next();
            String password2 = scanner.next();
            if (password.equals(password2)) {
                System.out.println("密码符合要求");
                break;
            } else {
                System.out.println("两次输入密码不一致，重输");
            }
        }
        //身份证的输入与检测
        while (true) {
            System.out.println("输入身份证号码：");
            ID = scanner.next();
            if (checkID(ID)) {
                System.out.println("身份证正确");
                break;
            } else System.out.println("身份证错误,重输");
        }
        //电话号码的输入与检测
        while (true) {
            System.out.println("输入电话号码：");
            phoneNumber = scanner.next();
            if (checkPhoneNumber(phoneNumber)) {
                System.out.println("电话号码正确");
                break;
            } else System.out.println("电话号码错误");
        }
        //加入集合
        User user = new User(username, password, ID, phoneNumber);
        list.add(user);
        printList(list);
    }

    //功能：检查用户名
    private static boolean checkUsername(String username) {
        //1.一般来讲是先验证格式是否正确，再去校验是否唯一：数据一般存储在数据库当中，需要使用网络资源
        //我的之前的做法是，全部检验一遍。。。。。
        //2.去除flag，使用return用来判断输入，提升效率

        //使用变量存储数据提高运行效率
        int len = username.length();
        if (len < 3 || len > 15) {
            System.out.println("用户名长度不符合标准");
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            //这里也用变量存储数据
            //这里之前判断字符用的是自己存储的字符数组，太占内存，可以直接判断大小。思维有点固化了：在产生验证码那里学到的东西用偏了。。。。。。
            char c = username.charAt(i);
            if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')) {
                System.out.println("只能为字母或者数字");
                return false;
            }
        }

        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (c > 'a' && c < 'z' || c > 'A' && c < 'Z') {
                return true;
            }
        }
        System.out.println("不能为纯数字");
        return false;
    }

    //功能：检查身份证
    private static boolean checkID(String ID) {
        //看看两种不同的写法：这一种returnID的方式的结构更加清晰，主要是面向重点不同
        //之前的版本里面重点在于录入，这里的重点在于判断字符串
        //之前的版本要创建多个Scanner，这个版本不需要
        //之前的版本要创建多个flag判断对错，这个不需要，遇到错误直接return就可以了
        // (之前的版本在使用charAt的时候出现了数组越界的错误。但是被我统一try-catch掉了。花了一点时间才发现。)
        if (ID.length() != 18) {
            System.out.println("身份证长度需要18位");
            return false;
        }
        if (ID.startsWith("0")) {//也可以用charAt，这里是新知识点，是0开头返回true，否则返回false
            System.out.println("身份证第一位不能为0！");
            return false;
        }
        for (int i = 0; i < ID.length() - 1; i++) {
            if (ID.charAt(i) < '0' || ID.charAt(i) > '9') {
                System.out.println("身份证前十七位必须为数字！");
                return false;
            }
        }
        char c = ID.charAt(ID.length() - 1);
        if ((c > '9' || c < '0') && c != 'x' && c != 'X') {
            System.out.println("身份证最后一位不是数字也不是X或者x！");
            return false;
        }
        return true;
    }

    //功能：检查电话号码
    private static boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            System.out.println("电话号码长度必须为11");
            return false;
        }
        if (phoneNumber.startsWith("0")) {
            System.out.println("电话号码第一位必须不为0");
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (c > '9' || c < '0') {
                System.out.println("电话号码长度必须全部是数字！");
                return false;
            }
        }
        return true;
    }

    //选项：登录
    private static boolean login(ArrayList<User> list) {
        //这个模块本来是用户名密码验证码同时判断
        System.out.println("欢迎登录");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名：");
        String username = scanner.next();
        int index = getIndex(list, username);
        //这里把注册用户提到前面
        if (index < 0) {
            System.out.println("用户名未注册，请先注册");
            return false;
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("输入密码：");
            String password = scanner.next();
            //判断验证码：验证码错误不减少机会
            while (true) {
                String str = getString();
                System.out.println("输入验证码：" + str);
                String myStr = scanner.next();
                if (!str.equalsIgnoreCase(myStr)) {
                    System.out.println("验证码输入错误");
                    continue;
                }
                break;
            }
            if (list.get(index).getPassword().equals(password)) {
                System.out.println("用户名密码验证码正确");
                return true;
            }
            System.out.println("密码或者验证码错误，请重新输入密码和验证码:还有" + (2 - i) + "次机会");
        }
        System.out.println("输入次数已经用完！");
        return false;
    }

    //选项：忘记密码
    private static void forgetPassword(ArrayList<User> list) {
        System.out.println("输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        int index = getIndex(list, username);
        //先判断错误：再进行接下来的操作：主要是为了避免在if里面的多层嵌套导致代码繁杂
        if (index < 0) {
            System.out.println("用户名未注册，请先注册");
            return;
        }
        System.out.println("输入身份证和手机号码：");
        String ID = scanner.next();
        String phoneNumber = scanner.next();
        User user = list.get(index);
        //在进行身份证号码比较的时候忽略大小写：主要是最后的X的判断不区分大小写
        //你可以对比一下，少了if的嵌套循环，代码清晰很多：主要是使用了return返回结束方法。
        //这才发现：原来我的if else都写不好。。。。
        //重要的一课：if后能尽量免除else减少嵌套（当代码量多的时候）
        if (!(user.getID().equalsIgnoreCase(ID) && user.getPhoneNumber().equals(phoneNumber))) {
            System.out.println("信息不对，修改失败");
            return;
        }
        String password;
        while (true) {
            System.out.println("输入密码进行修改：");
            password = scanner.next();
            System.out.println("再次输入密码进行验证：");
            String password2 = scanner.next();
            if (password.equals(password2)) {
                user.setPassword(password);
                System.out.println("密码输入正确，修改完成！");
                break;
            }
            System.out.println("两次密码不一致，重新输入：");
        }
    }

    //功能；根据用户名返回下标
    private static int getIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    //功能：根据用户名判断是否存在于集合中
    private static boolean contains(ArrayList<User> list, String username) {
        return getIndex(list, username) >= 0;
    }

    //功能；得到随机字母加数字共五位的字符串(一个数字随机位置)：
    private static String getString() {
        /*char[] chars = new char[52];
        for (int i = 0; i < 26; i++) {
            chars[i] = (char) ('a' + i);
            chars[i + 26] = (char) ('A' + i);
        }*/
        //存储字符：这里使用集合代替数组，空间占用更大一点：不过,意在方便与练习
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            //同样是循环26次，两个代码可以写道同一行
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }
        //老师这里是用的StringBuilder：但是我不知道怎么给最后一位的数字换位置
        //老师的方法是把sb转换成String再转换成toCharArray再去调整。觉得有些许麻烦，这里就不改了。
        char[] str = new char[5];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            //JDK5之后，char与Character可以相互转换，后面会学习
            str[i] = list.get(random.nextInt(list.size()));
        }
        str[4] = (char) ('0' + random.nextInt(10));
        //随机数字出现位置
        int i = random.nextInt(5);
        char temp = str[str.length - 1];
        str[str.length - 1] = str[i];
        str[i] = temp;
        return new String(str);
    }

    //功能：打印集合
    private static void printList(ArrayList<User> list) {
        System.out.println("姓名" + '\t' + "密码" + '\t' + "身份证" + '\t' + "手机号");
        for (User user : list) {
            System.out.println(user.getUsername() + '\t' + user.getPassword() + '\t' + user.getID() + '\t' + user.getPhoneNumber());
        }
    }
}
