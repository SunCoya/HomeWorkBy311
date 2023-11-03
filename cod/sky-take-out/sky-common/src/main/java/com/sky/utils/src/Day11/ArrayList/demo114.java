package Day11.ArrayList;

import java.util.ArrayList;
//在集合中不写泛型就可以写任意的类型
public class demo114 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add("abc");
        System.out.println(arrayList);
    }
}
