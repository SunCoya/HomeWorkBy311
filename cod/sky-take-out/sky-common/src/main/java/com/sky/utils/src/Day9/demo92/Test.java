package Day9.demo92;

import java.util.Scanner;
//Scanner中next()与nextline（）的区别：
//next（）遇到空格，制表符，回车就停止，当然nextInt,Double也是如此。
//nextline只会按回车停止。
//scanner.nextLine最好不要和其他键盘录入混用：nextLine()会存储着next()未能接收的字符
public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //输入1：第一段字符串 第二段字符串，前面还有一个空格
        //输入2：第一段字符串，第二段是一个回车符 回车
        String str1=scanner.next();
        System.out.println(str1);
        String str2=scanner.nextLine();
        System.out.println(str2);
    }
}
