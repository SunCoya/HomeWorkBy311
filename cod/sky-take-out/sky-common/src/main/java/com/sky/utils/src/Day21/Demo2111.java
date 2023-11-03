package Day21;

import java.util.Arrays;
//使用Java中的sort函数排序字符串：按照字符传长度排序
public class Demo2111 {
    public static void main(String[] args) {
        String[] strings = {"aaa","aaaa","aaaaa","aaaa","a","aa","aaaa"};
        Arrays.sort(strings,((o1, o2) -> o1.length()-o2.length()));
        System.out.println(Arrays.toString(strings));
    }
}
