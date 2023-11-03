package Day3;

//当”+“的操作中出现字符串时，这个符号便是字符串连接符，用于字符串的连接，最后的结果全变为字符串：
// 运算符‘+’是从左到右进行计算的，如果字符串前出现可运算的式子，则先进行数学运算
public class demo33 {
    public static void main(String[] args) {
        String a = "字符串";

        System.out.println("从左到右依次计算，此处先把前面的数字都加起来再连接字符串:");
        String a1 = 1 + 2 + 3 + a;
        System.out.println(a1);

        System.out.println("此处是一个一个字符进行连接");
        String a2 = a + 1 + 2 + 3;
        System.out.println(a2);
    }
}
