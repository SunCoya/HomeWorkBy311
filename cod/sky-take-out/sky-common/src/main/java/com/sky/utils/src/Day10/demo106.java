package Day10;

//反转字符串
public class demo106 {
    public static void main(String[] args) {
        String str = "123456789";
        System.out.println(StringReverse(str));
    }

    public static String StringReverse(String str) {
        String str1 = "";
        for (int i = str.length() - 1; i >= 0; i--) {//这里可以用str.length.forr快速生成
            str1 += str.charAt(i);
        }
        return str1;
    }
}
