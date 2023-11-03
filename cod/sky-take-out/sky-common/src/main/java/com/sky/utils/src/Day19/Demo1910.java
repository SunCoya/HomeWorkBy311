package Day19;

/*
    正则表达式在字符串方法中的使用
    1.如何使用正则表达式替换字符串中的某些字符？
    2.如何利用正则表达式分割字符串？
*/
public class Demo1910 {
    public static void main(String[] args) {
        String str = "小火龙sa87s4dsa5a551ssa567f8a4s56杰尼龟dsa8dd4a56d4567816dsa7c8xz妙蛙种子";
        System.out.println("1.使用字符串中的replaceAll方法替换字符串，这个方法在底层也会创建文本解析器对象matcher去替换字符串");
        String str1 = str.replaceAll("\\w+", "vs");
        System.out.println(str1);

        System.out.println("2.使用字符串中的split方法得到分割后的字符串");
        String[] str2 = str.split("\\w+");
        for (int i = 0; i < str2.length; i++) {
            System.out.print(str2[i] + " ");
        }
    }
}
