package Day18.demo180;

import java.math.BigDecimal;
import java.math.BigInteger;
// 查看一个对象中各个属性的方法：断点调试
public class Demo187 {
    public static void main(String[] args) {
        System.out.println("打上红点再debug可以进行断点调试，可以看到一个类中各个属性的值是什么样的");
        BigInteger bd = new BigInteger("27670116110564327424");
        BigDecimal bd1 = BigDecimal.valueOf(-0.226);
    }
}
