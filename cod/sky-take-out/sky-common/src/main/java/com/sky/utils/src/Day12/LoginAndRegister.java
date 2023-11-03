package Day12;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//自己写的版本：
//不会使用正则表达式，写起来很繁杂。
public class LoginAndRegister {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("zhangsan","123456","430945222245647897","18888888888"));
        list.add(new User("lisi","654321","430945222245647891","18888888889"));
        list.add(new User("wangwu","12345678","430945222245647892","18888888880"));
        list.add(new User("zhaoliu","87654321","430945222245647893","18888888881"));
        System.out.println("-------------欢迎来到黑马学生管理系统----------------");
        loop:while (true) {
            System.out.println("请选择操作  1登录  2注册  3忘记密码");
            Scanner scanner = new Scanner(System.in);
            try {
                int i = scanner.nextInt();
                switch (i) {
                    case 1 -> {
                        if (login(list)) break loop;
                    }
                    case 2 -> register(list);
                    case 3 -> forget(list);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println("欢迎登录！");
    }
    //登录选项
    private static boolean login(ArrayList<User> list) {
        System.out.println("欢迎登录");
        for (int i = 0; i < 3; i++) {
            System.out.println("输入用户名：");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.next();
            System.out.println("输入密码：");
            String password = scanner.next();
            String str = getString();
            System.out.println("输入验证码：" + str);
            String myStr = scanner.next();
            int index = getIndex(list, username);
            if (index >= 0) {
                if (list.get(index).getPassword().equals(password) && str.equalsIgnoreCase(myStr)) {
                    System.out.println("用户名密码验证码正确");
                    return true;
                } else {
                    System.out.println("密码或者验证码错误，请重新输入密码和验证码:还有" + (2 - i) + "次机会");
                }
            } else {
                System.out.println("用户名未注册，请先注册");
                return false;
            }
        }
        System.out.println("输入次数已经用完！");
        return false;
    }
    //注册选项
    private static void register(ArrayList<User> list) {
        System.out.println("欢迎注册");
        String username, password1, ID, phoneNumber;
        username = inputUsername(list);
        password1 = inputPassword();
        ID = inputID();
        phoneNumber = inputPhoneNumber();
        User user = new User(username, password1, ID, phoneNumber);
        list.add(user);
    }
    //输入用户名
    private static String inputUsername(ArrayList<User> list) {
        String username;
        Scanner scanner = new Scanner(System.in);
        char[] chars = getChars();
        while (true) {
            System.out.println("请输入用户名（3-15位字母加数字且不能为纯数字）：");
            username = scanner.next();

            boolean flag1 = false;
            for (int i = 0; i < username.length(); i++) {
                if (username.charAt(i) > '9' || username.charAt(i) < '0') {
                    flag1 = true;
                    break;
                }
            }
            if (flag1==false){
                System.out.println("不能为纯数字");
            }

            boolean flag2 = true;
            loop:for (int i = 0; i < username.length(); i++) {
                for (int j = 0; j < chars.length; j++) {
                    if (username.charAt(i) == chars[j]) {
                        break;
                    }
                    if (j == chars.length - 1) {
                        System.out.println("只能为字母或者数字");
                        flag2 = false;
                        break loop;
                    }
                }
            }

            boolean flag3=true;
            if (username.length() < 3 || username.length() > 15) {
                System.out.println("用户名长度不符合标准");
                flag3 = false;
            }

            boolean flag4=true;
            if (contains(list,username)){
                System.out.println("用户名已经存在");
                flag4=false;
            }

            if (flag1 && flag2 && flag3 && flag4) {
                System.out.println("用户名正确");
                break;
            } else {
                System.out.println("用户名错误，再次输入：");
            }
        }
        return username;
    }
    //输入密码：
    private static String inputPassword() {
        String password1;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用密码两次：");
            password1 = scanner.next();
            String password2 = scanner.next();
            if (password1.equals(password2)) {
                System.out.println("密码符合要求");
                break;
            } else {
                System.out.println("两次输入密码不一致，重输");
            }
        }
        return password1;
    }
    //输入身份证号码：
    private static String inputID() {
        String ID;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入身份证号码：");
            ID = scanner.next();
            boolean flag1 = true;
            if (ID.length() != 18) {
                flag1 = false;
                System.out.println("身份证长度需要18位");
                continue;
            }
            boolean flag2 = true;
            if (ID.charAt(0) == '0') {
                flag2 = false;
                System.out.println("身份证第一位不能为0！");
            }
            boolean flag3 = true;
            for (int i = 0; i < ID.length() - 1; i++) {
                if (ID.charAt(i) < '0' || ID.charAt(i) > '9') {
                    flag3 = false;
                    System.out.println("身份证前十七位必须为数字！");
                }
            }
            boolean flag4 = true;
            char c = ID.charAt(17);
            if ((c>'9'||c<'0')&&c!='x'&&c!='X') {
                flag4 = false;
                System.out.println("身份证最后一位不是数字也不是X或者x！");
            }
            if (flag1 && flag2 && flag3 && flag4) {
                System.out.println("身份证正确");
                break;
            } else System.out.println("身份证错误,重输");
        }
        return ID;
    }
    //输入电话号码：
    private static String inputPhoneNumber() {
        String phoneNumber;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入电话号码：");
            phoneNumber = scanner.next();
            boolean flag1 = true;
            if (phoneNumber.length() != 11) {
                flag1 = false;
                System.out.println("电话号码长度必须为11");
            }
            boolean flag2 = true;
            if (phoneNumber.charAt(0) == '0') {
                flag2 = false;
                System.out.println("电话号码第一位必须不为0");
            }
            boolean flag3 = true;
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (phoneNumber.charAt(i) > '9' || phoneNumber.charAt(i) < '0') {
                    flag3 = false;
                    System.out.println("电话号码长度必须全部是数字！");
                }
            }
            if (flag1 && flag2 && flag3) {
                System.out.println("电话号码正确");
                break;
            } else System.out.println("电话号码错误");
        }
        return phoneNumber;
    }
    //忘记密码选项
    private static void forget(ArrayList<User> list) {
        System.out.println("输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        int index = getIndex(list, username);
        if (index >= 0) {
            System.out.println("输入身份证和手机号码：");
            String ID = scanner.next();
            String phoneNumber = scanner.next();
            if (list.get(index).getID().equals(ID) && list.get(index).getPhoneNumber().equals(phoneNumber)) {
                System.out.println("输入密码进行修改：");
                String password = scanner.next();
                list.get(index).setPassword(password);
            } else {
                System.out.println("信息不对，修改失败");
            }
        } else {
            System.out.println("用户名未注册，请先注册");
        }
    }
    //根据用户名返回下标
    private static int getIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }
    //根据用户名判断是否存在于集合中
    private static boolean contains(ArrayList<User> list, String username){
        if (getIndex(list,username)==-1){
            return false;
        }else return true;
    }
    //得到随机字母加数字五位字符串
    private static String getString() {
        char[] str=new char[5];
        Random random = new Random();
        char[] chars = getChars();
        for (int i = 0; i < 4; i++) {
            str[i]=chars[random.nextInt(52)];
        }
        str[4]=chars[random.nextInt(52,62)];
        int i=random.nextInt(5);
        char temp=str[4];
        str[4]=str[i];
        str[i]=temp;
        return new String(str);
    }
    //得到全部字母加数字的字符数组
    private static char[] getChars() {
        char[] chars = new char[62];//存储字母加数字
        for (int i = 0; i < 26; i++) {
            chars[i] = (char) ('a' + i);
        }
        for (int i = 0; i < 26; i++) {
            chars[i + 26] = (char) ('A' + i);
        }
        for (int i = 0; i < 10; i++) {
            chars[i + 52] = (char) ('0' + i);
        }
        return chars;
    }
}
