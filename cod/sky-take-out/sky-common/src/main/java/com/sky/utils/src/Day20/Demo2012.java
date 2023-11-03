package Day20;
//StringBuilder反向插值：十进制转2进制案例
public class Demo2012 {
    public static void main(String[] args) {
        int a = 666;
        System.out.println(Integer.toBinaryString(a));
        int b;
        StringBuilder sb = new StringBuilder();
        System.out.println("使用insert方法可以指定插入位置，如insert（0，参数）可以反向插入");
        while (a !=0) {
            b = a % 2;
            a /= 2;
            sb.insert(0,b);
        }
        System.out.println(sb);
    }
}
