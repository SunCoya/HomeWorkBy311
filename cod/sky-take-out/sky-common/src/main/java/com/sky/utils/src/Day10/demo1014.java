package Day10;

import java.util.StringJoiner;

//StringJoiner：可以简化StringBuilder的书写
//StringJoiner的使用案例：把数组转化为字符串的格式输出
public class demo1014 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        StringJoiner sj = new StringJoiner(", ");//分隔符号
        for (int i = 0; i < arr.length; i++) {
            sj.add(arr[i] + "");
        }
        System.out.println("只加分隔符号的StringJoiner："+sj);

        StringJoiner sj1 = new StringJoiner(", ", "[", "]");//分隔符号，开始符号，结束符号。
        for (int i = 0; i < arr.length; i++) {
            sj1.add(arr[i] + "");
        }
        System.out.println("加了分隔符号，开始符号，结束符号的StringJoiner："+sj1);

        String str = sj1.toString();
        System.out.println("使用toStirng方法把StringJoiner转换为支付串"+str);
        System.out.println("使用length方法得到StringJoiner的长度"+sj1.length());
    }
}
