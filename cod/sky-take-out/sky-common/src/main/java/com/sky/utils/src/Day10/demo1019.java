package Day10;
//把一个字符串的第一位移动到最后一位，看看这个重复过程能不能与另一个字符串的值相等
//String版
public class demo1019 {
    public static void main(String[] args) {
        String A = "abcde";
        String B = "eabcd";
        if (A.length() == B.length()) {
            for (int i = 0; i < A.length(); i++) {
                A = change(A);
                if (A.equals(B)) {
                    System.out.println("可");
                    return;
                }
            }
        }
        System.out.println("否");
    }

    public static String change(String s) {
        //把String类型转化为char[]类型可以用toCharArray方法
        String end = s.substring(1);
        char start = s.charAt(0);
        return end + start;
    }
}
