package Day22;

import java.util.ArrayList;
import java.util.Iterator;

/*
迭代器底层：以ArrayList为例
在ArrayList里面创建了一个私有的内部类的对象，这个对象，实现了迭代器这个接口
在接口对象里面：定义了一个下标，一个上一次返回的下标，还有一个是集合变化的次数的记录
hasNext：判断当前对象是否有元素，就是一个判断是否到达最大值。
next：在这里面注意，内部类使用外部类的元素使用的ArrayList.this.elementData，这里是为了区分外部类元素与内部类元素
每次next的时候都会看是否有集合的数量变化：如果有变化就会报错。
*/
public class Demo2210 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        arrayList.add("eee");
        //这里使用的是接口名接收的对象，故能够使用这个对象的方法
        //但也只能给你用用实现都方法了，只要是接口，实现类的变量是都用不了的
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        //改动代码：demo158，demo312
    }
}
