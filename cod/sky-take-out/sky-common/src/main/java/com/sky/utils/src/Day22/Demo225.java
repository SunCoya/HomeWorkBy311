package Day22;

import java.util.ArrayList;

//List常见方法与5种遍历方式
public class Demo225 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        //增 add方法指定下标不能越界
        arrayList.add("aaa");
        arrayList.add(1, "bbb");
        System.out.println(arrayList);

        //删
        arrayList.remove(1);
        System.out.println(arrayList);

        //改 修改元素，注意不能修改不存在的元素
        //返回被修改的元素
        System.out.println(arrayList.set(0, "ccc"));

        //查
        System.out.println(arrayList.get(0));
    }
}
