package Day10;
import java.util.Locale;
//忽略大小写比较字符串
//把字符串中的字母全部转为大写字母
public class demo103 {
    public static void main(String[] args) {
        String s1 = "ABCDEFG1122";
        System.out.println("abcdefg1122".equalsIgnoreCase(s1));
        String s2= "qwertyuiop";
        System.out.println(s2.toUpperCase(Locale.ROOT));
    }
}
