package Day22;

import java.util.ArrayList;

//List中的remove方法:当存储的是Integer数据类型时的特殊情况：想要删除特定数字，需要创建Integer对象
public class Demo226 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.remove(Integer.valueOf(1));
        System.out.println(arrayList);
    }
}
