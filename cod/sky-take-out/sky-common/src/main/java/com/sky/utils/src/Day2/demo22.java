package Day2;

//'\t'的使用：在输出的时候，把前面的字符串长度补齐到8
public class demo22 {
    public static void main(String[] args) {
        //如果’\t‘出现在字符串中，不会改变字符串长度，这个符号只占用一个位置。
        System.out.println("\'t\'前面是数字的情况,这里数字部分输出的是4444+9：");
        System.out.println(4444 + '\t' + "Hello");
        System.out.println("在字符串中使用\\t也能达到制表符的效果。这一行是全转化为字符串再进行的输出:");
        System.out.println(4444 + "\t" + "Hello");

        System.out.println("\'t\'前面是空的情况：IDEA中输出中会默认补齐4位");
        System.out.println('\t' + "Hello");

        System.out.println("\'t\'前面是字符串的情况：，IDEA中输出时中前面的字符串大于等于4位时补齐8位,否则补齐4位");
        System.out.println("333" + '\t' + "Hello");
        System.out.println("4444" + '\t' + "Hello");
        System.out.println("7777777" + '\t' + "Hello");

        System.out.println("\'t\'前面的字符串长度到了八位会再补齐八位，如果在IDEA中输出会是补齐4位");
        System.out.println("88888888" + '\t' + "Hello");

        System.out.println();
        System.out.println("在实际的打印过程中的使用:");
        System.out.println("name" + '\t' + "age" + '\t' + "class");
        System.out.println("Cocoya" + '\t' + "20" + '\t' + "1803");
    }
}
