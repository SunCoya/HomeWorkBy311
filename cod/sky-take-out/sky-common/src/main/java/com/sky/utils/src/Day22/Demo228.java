package Day22;

import java.util.ArrayList;

//ArrayList底层原理
/*
ArrayList底层为数组
空参构造的集合，创建长度默认为0
添加第一个元素的时候，扩容为10
存满则自动扩容1.5倍（底层是再加原容量右移一位之后的新容量）
如果扩容之后也超过容量，则按照加入的元素量来扩容（有多少加多少
扩容使用arrays.copyOf,创建新的数组然后复制
看源码即可，顺着add方法往下走
）
*/
public class Demo228 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(arrayList);
    }
}
