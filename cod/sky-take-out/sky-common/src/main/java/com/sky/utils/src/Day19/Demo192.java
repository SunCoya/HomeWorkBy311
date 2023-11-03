package Day19;
/*
正则表达式：匹配预定义的单个字符
1.使用预定义字符用正斜杠还是反斜杠？大字母与小字母的区别？
2.如何匹配任何字符？
3.如何匹配数字？
4.如何匹配空白？
5.如何匹配数字字母下划线？
*/

public class Demo192 {
    public static void main(String[] args) {
        System.out.println("1.使用反斜杠：小写字母匹配是，大写字母匹配否");
        System.out.print("2.匹配任何单个字符。需要注意.不能够匹配换行符号\\n：");
        System.out.println("原".matches("."));

        System.out.print("3.匹配数字：");
        System.out.println("6".matches("\\d"));

        System.out.print("匹配非数字：");
        System.out.println("6".matches("\\D"));

        System.out.print("4.匹配空白字符：");
        System.out.println(" ".matches("\\s"));

        System.out.print("匹配非空白字符：");
        System.out.println(" ".matches("\\S"));

        System.out.print("5.匹配数字字母下划线：");
        System.out.println("_".matches("\\w"));

        System.out.print("匹配非数字字母下划线；");
        System.out.println("_".matches("\\W"));
    }
}
