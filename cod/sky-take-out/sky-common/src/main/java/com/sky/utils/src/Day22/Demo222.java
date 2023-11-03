package Day22;
import java.util.ArrayList;
import java.util.Iterator;
//Collection元素遍历方式:迭代器（可以在有元素要删除的时候用）
public class Demo222 {
    public static void main(String[] args) {
        //迭代器遍历：迭代器不依赖索引，在Java中类是Iterator，是集合专用遍历方式
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        arrayList.add("eee");
        //1.利用集合对象的方法，创建迭代器对象，默认指向0索引
        Iterator<String> iterator = arrayList.iterator();
        //2.判断当前位置是否有元素
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
        arrayList.add("fff");
        //再次获取新的迭代器
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.print(str + " ");
            if (str.equals("fff"))
            //3.有元素则输出元素，然后后移，注意:遍历的时候不要用集合的方法增加或者删除元素
            //只能用迭代器的方法移除迭代器返回的最后一个元素(后面看源码再讲原因)
            iterator.remove();
        }
        System.out.println(arrayList);
    }
}
