package Day3;

//不同类型的变量也可以进行比较：相同的值就相等
public class demo35 {
    public static void main(String[] args) {
        byte a1 = 65;
        short a2 = 65;
        int a3 = 65;
        double a4 = 65.00000000;
        char a5 = 65;
        System.out.println("相同值，不同类型的变量进行比较，结果为：");
        System.out.println(a1 == a2 && a3 == a4 && a4 == a5);
    }
}
