package Day11.ArrayList;

import java.util.ArrayList;
//集合存储基本数据类型的包装类
public class demo113 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        //jdk5以后，int与Integer可以相互转换
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        System.out.println("集合添加整数："+list1);
        ArrayList<Character> list2= new ArrayList<>();
        list2.add('a');
        list2.add('b');
        list2.add('c');
        list2.add('d');
        System.out.println("集合添加字符："+list2);
    }
}
