package Day19;

/*
    忽略大小写匹配
   1.匹配正则表达式如何忽略大小写？
   2.如何显示忽略大小写的范围？
*/
public class Demo195 {
    public static void main(String[] args) {
        System.out.println("1.忽略大小写的正则表达式：（？i）后面的内容就是忽略大小的内容");
        String regex = "(?i)abc";
        System.out.println("ABC".matches(regex));

        System.out.println("2.使用括号限定范围");
        regex = "((?i)a)bc";
        System.out.println("Abc".matches(regex));
    }
}
