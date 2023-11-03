package Day3;
//探究整数右移、左移的结果
public class demo311 {
    public static void main(String[] args) {
        int a=16;
        //原：00000000 00000000 00000000 00010000
        //反：00000000 00000000 00000000 00010000
        //补：00000000 00000000 00000000 00010000
        int b=15;
        //原：00000000 00000000 00000000 00001111
        //反：00000000 00000000 00000000 00001111
        //补：00000000 00000000 00000000 00001111
        int c=-16;
        //原：10000000 00000000 00000000 00010000
        //反：11111111 11111111 11111111 11101111
        //补：11111111 11111111 11111111 11110000
        int d=-15;
        //原：10000000 00000000 00000000 00001111
        //反：11111111 11111111 11111111 11110000
        //补：11111111 11111111 11111111 11110001
        System.out.println("左移一位：补码全部向左移动！空位补0！相当于原来的数字*2");
        //注意：移动的位置太多，或者移动的数字很大，左移就不是原来的数字*2的次方的结果了
        System.out.println(a<<1);
        //补反原：  00000000 00000000 00000000 00010000
        //左移：00000000 00000000 00000000 00100000
        System.out.println(b<<1);
        //补反原：  00000000 00000000 00000000 00001111
        //左移：00000000 00000000 00000000 00011110
        System.out.println(c<<1);
        //补：11111111 11111111 11111111 11110000
        //左移：11111111 11111111 11111111 11100000
        //反：11111111 11111111 11111111 11011111
        //原：10000000 00000000 00000000 00100000
        System.out.println(d<<1);
        //补：11111111 11111111 11111111 11110001
        //左移：11111111 11111111 11111111 11100010
        //反：11111111 11111111 11111111 11100001
        //原：10000000 00000000 00000000 00011110
        System.out.println("右移一位：补码全部向右移动！空位正数补0负数补1！相当于原来的数字/2,注意负数是向下取整");
        System.out.println(a>>1);
        //补反原：  00000000 00000000 00000000 00010000
        //右移：00000000 00000000 00000000 00001000
        System.out.println(b>>1);
        //补反原：  00000000 00000000 00000000 00001111
        //右移：00000000 00000000 00000000 00000111
        System.out.println(c>>1);
        //补：11111111 11111111 11111111 11110000
        //右移：11111111 11111111 11111111 11111000
        //反：11111111 11111111 11111111 11110111
        //原：10000000 00000000 00000000 00001000
        System.out.println(d>>1);
        //补：11111111 11111111 11111111 11110001
        //右移：11111111 11111111 11111111 11111000
        //反：11111111 11111111 11111111 11110111
        //原：10000000 00000000 00000000 00001000
    }
}