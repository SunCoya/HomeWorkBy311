package Day19;

/*
正则表达式：单个字符
1.如何表示单个字符？
2.如何表示除了这个字符以外的单个字符？
3.如何表示某一段范围内的字符？
4.如何表示多段范围内的字符？
5.如何表示两段字符的交集？
6.如何去除某段字符中的某几个字符？
7.如何去除某段字符中的某段字符？
8.某段字符中去除多段字符？
*/
public class Demo191 {
    public static void main(String[] args) {
        System.out.print("1.abc当中的任意一个字符：（一个方括号代表一个字符）");
        System.out.println("a".matches("[abc]"));

        System.out.print("2.非abc的任意一个字符：");
        System.out.println("?".matches("[^abc]"));

        System.out.println("可以注意到-左右两边连接两个字符，这三个字符：”*-*“这就代表了这个范围内的某个字符");
        System.out.print("3.全字母：");
        System.out.println("R".matches("[a-zA-z]"));

        System.out.print("4.多段范围的字母：");
        System.out.println("f".matches("[[a-b][c-d][e-f]]"));

        System.out.print("5.某段范围与某几个字母的交集");
        System.out.println("e".matches("[a-z&&d-f]"));

        System.out.println("上面的中括号里面的中括号可加可不加，但是到了下面碰到了^这个字符，就需要加中括号");
        System.out.print("6.某段范围中去除某几个字母：");
        System.out.println("r".matches("[a-z&&[^aple]]"));

        System.out.print("7.某段范围中去除某一段字母：");
        System.out.print("r".matches("[a-z&&[^d-f]]") + " ");//等价写法
        System.out.println("r".matches("[a-cg-z]"));

        System.out.print("8.某段范围中去除多段字母：");
        System.out.print("z".matches("[a-z&&[^d-f]&&[^j-y]]") + " ");
        System.out.println("z".matches("[a-cg-iz]"));//等价写法

    }
}
