package Day19;
/*
    利用分组判断字符串中是否具有相同的字符段落
    1.用什么符号来表示分组？
    2.怎么看分组的组号？
    3.如何把组号中的数据拿出来再次使用？
*/
public class Demo1911 {
    public static void main(String[] args) {
        System.out.println("1.分组：用小括号来表示");
        System.out.println("2.组号看小括号的位置，有多少对小括号就有多少组，从左往右排组号，从1开始");
        System.out.println("3.\\\\组号：表示把第一组的数据拿出来用一次");

        System.out.println("判断字符串的开始字符和结束字符是否一致(一个字符)");
        String regex1 = "(.).+\\1";
        System.out.println("hahah".matches(regex1));
        System.out.println("haha".matches(regex1));

        System.out.println("判断字符串的开始字符和结束字符是否一致(多个字符)");
        String regex2 = "(.+).+\\1";
        System.out.println("hahagagaha".matches(regex2));
        System.out.println("hahagagaga".matches(regex2));

        System.out.println("判断字符串的开始字符和结束字符是否一致(多个字符，各段字符中的每个字符都相等)");
        String regex3 = "((.)\\2*).+\\1";
        System.out.println("hahagagaha".matches(regex3));
        System.out.println("hahagagahah".matches(regex3));
        System.out.println("aaagagagagaaa".matches(regex3));
    }
}
