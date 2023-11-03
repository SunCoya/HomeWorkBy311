package Day2;

//整数型型变量大致范围
public class demo21 {
    public static void main(String[] args) {
        byte a = 0b1111111;
        short b = 0b111111111111111;
        int c = 0b1111111111111111111111111111111;
        long d = 0b111111111111111111111111111111111111111111111111111111111111111L;
        System.out.println("byte（1字节）类型范围：" + (-a - 1) + "~" + a);
        System.out.println("short（2字节）类型 大致范围：约三万二：" + (-b - 1) + "~" + b);
        System.out.println("int（4字节）类型 大致范围：约21亿：" + (-c - 1) + "~" + c);
        System.out.println("long（8字节）类型 大致范围：共19位：" + (-d - 1) + "~" + d);
    }
}
