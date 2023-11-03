package Day19;

/*
正则表达式实战：匹配邮箱
 1.在表示单个字符的时候如果省去外围的[] ，则&&符号会不会生效？
 2.如何多次表示某一段字符？
 3.如何表示小数点这个符号？
 4.怎么用正则搜索if else的结构：比如说搜索com或者是cn:
   [com]?[cn]?这样写会搜索到com后面也接着一个cn的情况，如何只搜索com或者只搜索cn呢?
*/
public class Demo194 {
    public static void main(String[] args) {
        String email = "3342824499@qq.com.cn";
        String myEmail = "SunCoya@163.com";
        System.out.println("1.这里在表示数字字母时，去掉了下划线的情况，在表示单个字符时需要加外围的“[  ]”");
        System.out.println("外围没有[]，则&&不会生效,只是表示这两个字符");

        System.out.println("2.小括号代表分组，后面可以接上数量控制,可以表示多段匹配内容的字符");

        System.out.println("3.这里小数点要转义w(ﾟДﾟ)w：\\.在正则里面表示小数点，非任意字符");

        System.out.println(email.matches("[\\w&&[^_]]+@[\\w&&[^_]]+(\\.[a-zA-Z]{2,3}){1,2}"));
        System.out.println(myEmail.matches("[\\w&&[^_]]+@[\\w&&[^_]]+(\\.[a-zA-Z]{2,3}){1,2}"));

        System.out.println("4.使用|表示或，后面记得加大括号限定范围，不加大括号限定范围会导致只匹配cn");
        System.out.println(myEmail.matches("\\w*@\\w*\\.(com|cn|edu)"));
        System.out.println(myEmail.matches("\\w*@\\w*\\.com|cn"));
    }
}
