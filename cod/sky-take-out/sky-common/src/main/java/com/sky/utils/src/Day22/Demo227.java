package Day22;
import java.util.ArrayList;
import java.util.ListIterator;

//List第5种遍历方式:列表迭代器ListIterator:继承于Iterator，是子接口，可以在遍历过程中加元素
public class Demo227 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        ListIterator<String> li = arrayList.listIterator();
        //方法中有add（） 来增加元素,增加的位置在当前迭代器指向的位置
        while (li.hasNext()){
            li.add("???");
            String str = li.next();
            System.out.println(str);
            if ("aaa".equals(str)){//尽量把不为空的写前面
                li.add("eee");
            }
        }
        System.out.println(arrayList);

    }
}
