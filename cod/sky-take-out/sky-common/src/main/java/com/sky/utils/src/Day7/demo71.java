package Day7;

import java.util.Random;
//定义一个方法随机产生一个五位数验证码：长度为五，前四位是字母，最后一位是数字
public class demo71 {
    public static void main(String[] args) {
        String str = getString();
        System.out.println(str);
    }

    private static String getString() {
        Random random = new Random();
        //回顾知识：当int与char类型做运算时，会全部转为int类型再计算
        //存放字母a-z与A-Z，这两段字母在ascii码中不是连续的，在此处存放字母整理（不整理也行，也能在随机数上取思考来解决这个问题）
        char[] characters = new char[52];
        for (int i = 0; i < 26; i++) {
            characters[i] = (char) ('a' + i);
        }
        for (int i = 0; i < 26; i++) {
            characters[i + 26] = (char) ('A' + i);
        }

        //验证码前四位字母
        String str = "";
        for (int i = 0; i < 4; i++) {
            int r1 = random.nextInt(52);
            str += characters[r1];
        }

        //验证码最后一位数字:在’+‘运算中出现String类型时结果统一变为字符串类型
        str +=random.nextInt(10);
        return str;
    }
}