package Day18.demo180;
import java.math.BigDecimal;
import java.math.RoundingMode;

/*
BigDecimal：用于精确的小数运算
1.计算机中的小数是如何存储的？
2.如何创建大浮点数？
3.如何使用静态方法创建大浮点数？
4.BigDecimal中的除法运算怎么设置小数保留？
*/
public class Demo186 {
    public static void main(String[] args) {
        System.out.println("1.计算机中的小数存储：比如69.875" + "会存储两部分数据：" + "整数存储0100 0101\n" +
                "小数部分存储111：0.5+0.25+0.125（底数乘以奇数的全次幂再全相加）\n" +
                "如果说是0.9，小数部分将要用很多位才能表示完全（这里就不谈小数部分的加减了）");
        System.out.print("故小数运算可能不精确：");
        System.out.println((0.09+0.01));

        System.out.print("2.建议使用传递字符串来创建对象，数据精确：");
        System.out.println(new BigDecimal("0.01"));


        System.out.println("3.通过静态方法获取对象,这个类里面已经创建好了1-10的long型静态变量");
        System.out.print("如果表示数字没有超出double范围建议使用静态方法：");
        BigDecimal bd = BigDecimal.valueOf(10);
        System.out.println(bd);


        System.out.println("4.设置舍入模式：UP是远离0的舍入模式，DOWN是靠近0的舍入模式，CEILING向上取整，FLOOR向下取整,HALF_UP四舍五入");
        System.out.println(bd.divide(bd,2,BigDecimal.ROUND_HALF_UP)+" "+bd.divide(bd,2, RoundingMode.HALF_UP));
    }
}
