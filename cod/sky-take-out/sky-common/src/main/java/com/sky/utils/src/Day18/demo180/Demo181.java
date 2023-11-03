package Day18.demo180;
/*
Math工具类
1.求平方根的两种函数？
2.求立方根的函数是什么？
3.如何利用Math工具类得到0-1的double小数？
*/
public class Demo181 {
    public static void main(String[] args) {
        System.out.println("1.求平方根："+Math.pow(4,0.5)+" "+Math.sqrt(4));
        System.out.println("2.求立方根："+Math.cbrt(8));
        System.out.println("3.返回double随机值(0<=x<1)："+Math.random());
    }
}
