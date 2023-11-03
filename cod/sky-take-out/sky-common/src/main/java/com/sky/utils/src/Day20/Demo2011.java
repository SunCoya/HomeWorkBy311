package Day20;
/*
Integer的静态方法
如何使用静态方法转换数字成不同进制的字符串？
如何把字符串转换成int类型的数字？
*/
public class Demo2011 {
    public static void main(String[] args) {
        System.out.println("1.使用to...String转不同进制字符串");
        String str = Integer.toBinaryString(Integer.MAX_VALUE);
        System.out.println(str);
        System.out.println(Integer.toOctalString(Integer.MAX_VALUE));
        System.out.println(Integer.toHexString(Integer.MAX_VALUE));

        System.out.println("2.使用parseInt解析字符串转成int，别的包装类也是这样");
        int i = Integer.parseInt("123");
        System.out.println(i);
    }
}
