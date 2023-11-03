package Day5;

import java.util.Random;

//获取随机数的练习
//1.产生数的范围0-99
//2.生成10次，1-10之间的整数
public class demo51 {
    public static void main(String[] args) {
        Random random = new Random();
        //小括号内的值，里面是生成随机数的个数，从零开始，共100（你写的数字）个数字
        int number1 = random.nextInt(100);
        System.out.println(number1);
        for (int i = 0; i < 10; i++) {
            int number2 = random.nextInt(10) + 1;
            System.out.print(number2);
        }
    }
}
