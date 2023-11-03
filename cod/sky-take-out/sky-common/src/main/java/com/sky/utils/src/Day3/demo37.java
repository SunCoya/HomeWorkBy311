package Day3;

//短路逻辑运算符的效果演示：
public class demo37 {
    public static void main(String[] args) {
        System.out.println("短路逻辑或：前面的语句为true，后面的语句就不用再执行了");
        int a = 1;
        System.out.println(a == 1 || a++ == 1);//（true||true）
        System.out.println("后面的语句没有执行,a为"+a);
        a = 1;
        System.out.println(a == 2 || a++ == 1);//（false||true）
        System.out.println("后面的语句执行了,a为"+a);

        System.out.println("短路逻辑与:前面的语句为false，后面的语句就不用执行了");
        a = 1;
        System.out.println(a == 2 && a++ == 1);//（false&&true）
        System.out.println("后面的语句没有执行,a为"+a);
        a = 1;
        System.out.println(a == 1 && a++ == 1);//（true&&true）
        System.out.println("后面的语句执行了,a为"+a);

        System.out.println("在逻辑与，逻辑非中，语句都要执行：");
        a = 1;
        System.out.println(a == 1 | a++ == 1);//（true|true）
        System.out.println(a);
        a = 1;
        System.out.println(a == 2 & a++ == 1);//（false&true）
        System.out.println(a);
    }
}
