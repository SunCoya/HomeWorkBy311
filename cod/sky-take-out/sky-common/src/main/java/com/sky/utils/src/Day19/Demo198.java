package Day19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//条件爬取
//如何查找后面不是11和17的Java字符串？
public class Demo198 {
    public static void main(String[] args) {
        String str = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";
        System.out.println("使用（？！内容）查找后面不是11和17的Java字符串");
        Pattern p = Pattern.compile("Java(?!11|17)");
        Matcher m = p.matcher(str);
        while (m.find()) {
            String strFind = m.group();
            System.out.print(strFind + " ");
        }
    }
}
