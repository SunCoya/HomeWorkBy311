package Day18.demo180;

import java.math.BigInteger;
import java.util.Random;

/*
BigInteger大整数类
1.如何获取一个随机大整数？
2.如何获取一个指定的大整数？
3.如何获取指定进制的大整数?
4.如何静态方法获取BigInteger?
5.静态方法获取BigInteger的优点?
6.大整数对象一旦创建，内部数据能改变吗？
*/
public class Demo184 {
    public static void main(String[] args) {
        System.out.print("1.获取一个随机大整数:数字代表2的几次方：");
        System.out.println(new BigInteger(63,new Random()));

        System.out.print("2.获取一个指定的大整数，最常用：");
        System.out.println(new BigInteger("100000000000000000000000000000"));

        System.out.print("3.获取指定进制的大整数,后面的数字是进制数，前面的数字是该进制的数：");
        System.out.println(new BigInteger("1111111111111111111111111111111",2));

        System.out.print("4.静态方法获取BigInteger：只能传最多Long类型的范围数据进去");
        System.out.println(BigInteger.valueOf(Long.MAX_VALUE));

        System.out.println("5.优点：提前创建了静态的-16到16的对象，多次重复获取不会创建新对象");
        System.out.print("使用静态方法创建的-16-16内的大整数为同一对象：");
        System.out.println((BigInteger.valueOf(16)==BigInteger.valueOf(16)));
        System.out.print("不在此范围内的大整数为不同对象：");
        System.out.println((BigInteger.valueOf(17)==BigInteger.valueOf(17)));

        System.out.println("6.大整数对象一旦创建，内部数据不能改变，只能创建新变量接收计算后的大整数");
    }
}
