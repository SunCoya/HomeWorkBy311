package Day19;

//案例：把字符串中重复的单个字符替换成一个
//如何在组外表示分组？
public class Demo1912 {
    public static void main(String[] args) {
        String str = "我要学学学学学学学编编编编编编编编编编程程程程程程程程程程程程程";
        System.out.println("组外使用$表示分组");
        System.out.println(str.replaceAll("(.)\\1+", "$1"));
    }
}
