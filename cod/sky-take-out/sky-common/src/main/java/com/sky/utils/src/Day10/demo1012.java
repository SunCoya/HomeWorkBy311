package Day10;

import java.util.Scanner;

//链式编程：在调用方法的时候，不需要用变量接受结果，可以继续调用其他方法。
public class demo1012 {
    public static void main(String[] args) {
        System.out.println(getString().substring(1).replace("A", "B"));
    }
    public static String getString() {
        System.out.println("请输入一个字符串");
        String str = new Scanner(System.in).next();
        return str;
    }
}
