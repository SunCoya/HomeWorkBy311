package Day19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    贪婪爬取与非贪婪爬取
    1.正则表达式默认是贪婪爬取还是非贪婪爬取？
    2.如何使用非贪婪爬取呢？
*/
public class Demo199 {
    public static void main(String[] args) {
        String str = "abbba";
        System.out.println("1.默认尽可能多获取b(贪婪爬取)");
        Pattern p1 = Pattern.compile("ab+");
        System.out.println("2.尽可能少获取b,在数量控制的后面加个问号（表示匹配但是只捕获尽量少的内容）（非贪婪爬取）");
        Pattern p2 = Pattern.compile("ab+?");
        Matcher m = p2.matcher(str);
        while (m.find()) {
            String strFind = m.group();
            System.out.print(strFind + " ");
        }
        System.out.println();
    }
}
