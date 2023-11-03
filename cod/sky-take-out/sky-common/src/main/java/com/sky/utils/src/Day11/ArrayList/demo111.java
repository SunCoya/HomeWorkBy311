package Day11.ArrayList;

import java.util.ArrayList;

//创建集合对象：
//集合相较于数组的特点：
//1.集合长度可变
//2.集合不能直接存储基本数据类型,需要转换成包装类
public class demo111 {
    public static void main(String[] args) {
        //泛型：限定集合中存储数据的类型,写在方括号里面
        //在JDK7以后，后面的new ArrayList<String>()可以改成下面的句子：
        ArrayList<String> list = new ArrayList<>();
        //打印对象是集合的内容
        System.out.println(list);
    }
}
