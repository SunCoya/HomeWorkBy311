package Day19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    本地爬虫
    本地爬虫需要用到的两个类：
    1.Pattern是什么类？
    2.Matcher是什么类？
    本地爬虫步骤：
    1.如何获取Pattern对象？
    2.如何获取matcher对象？
    3.如何使用matcher判断是否有匹配的字符？
    4.如何提取出matcher匹配到的对象？
    5.如何使用循环来进行爬虫？
*/
public class Demo196 {
    public static void main(String[] args) {
        String str = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";

        System.out.println("本地爬虫需要使用的类");
        System.out.println("1.Pattern类：表示正则表达式");
        System.out.println("2.Matcher类：文本匹配器，按正则表达式规则从头读取字符串：在大串中找符合匹配规则的字串");

        System.out.println("1.使用静态方法compile获取Pattern对象:正则表达式的对象");
        Pattern p = Pattern.compile("Java\\d{0,2}");

        System.out.println("2.使用Pattern的matcher方法获取文本匹配器的对象：要在str字符串中找符合p规则的小串串");
        Matcher m = p.matcher(str);

        System.out.println("3.根据find方法寻找是否有满足规则的字串，没有则返回false，有则返回true,在底层记录字串位置");
        System.out.println(m.find());

        System.out.println("4.根据find方法记录的索引,使用group方法进行字符串截取，到这里也只是截取了一个");
        String str1 = m.group();
        System.out.println(str1);

        System.out.println("第二次调用的时候会继续往后面读，重新进行记录");
        System.out.println(m.find());
        str1 = m.group();
        System.out.println(str1);

        System.out.println("5.使用循环案例：");
        Matcher m2 = p.matcher(str);
        while (m2.find()) {
            String strFind = m2.group();
            System.out.print(strFind + " ");
        }
    }
}
