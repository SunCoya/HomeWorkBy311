package Day18.demo180;
import java.math.BigInteger;
import java.util.Arrays;

/*
BigInteger：大整数计算方法
1.加减乘除次幂
2.除且取余
3.比较结果
4.返沪较大值
5.变回int类型数据
*/
public class Demo185 {
    public static void main(String[] args) {
        BigInteger bd1 = BigInteger.valueOf(15);
        BigInteger bd2 = BigInteger.valueOf(6);
        System.out.print("1.加减乘除次幂；");
        System.out.println(bd1.add(bd2)+" "+bd1.divide(bd2)+" "+bd1.multiply(bd2)+" "+bd1.divide(bd2)+" "+bd1.pow(2));

        System.out.print("2.除取余数：");
        System.out.println(Arrays.toString(bd1.divideAndRemainder(bd2)));

        System.out.print("3.比较结果是否相同：");
        System.out.println(bd1.equals(new BigInteger("15")));

        System.out.print("4.返回较大值：");
        System.out.println(bd1.equals(new BigInteger("15")));

        System.out.print("5.变回int类型：");
        System.out.println( bd1.intValue());
    }
}
