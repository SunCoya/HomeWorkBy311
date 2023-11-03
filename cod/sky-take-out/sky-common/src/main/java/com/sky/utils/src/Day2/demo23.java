package Day2;

//不同进制的表示方法与以不同进制进行输出
public class demo23 {
    public static void main(String[] args) {
        int a = 0b10000;//二进制
        int b = 020;//八进制
        int c = 16;//十进制
        int d = 0x10;//十六进制
        System.out.println("用不同进制创建int类型变量，输出都会是10进制：");
        System.out.println(a + " " + b + " " + c + " " + d);

        System.out.println("以二进制格式输出:使用Integer类的toString方法");
        String s = Integer.toBinaryString(c);
        System.out.println(s);

        System.out.println("以八进制格式输出:使用printf输出（%o）");
        System.out.printf("%o", c);
        System.out.println();

        System.out.println("以十六进制格式输出:使用printf输出（%x）");
        System.out.printf("%x", c);
    }
}
