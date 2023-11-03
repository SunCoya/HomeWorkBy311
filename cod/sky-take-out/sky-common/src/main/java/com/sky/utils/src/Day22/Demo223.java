package Day22;
import java.util.ArrayList;
import java.util.Collection;
//增强for循环遍历
public class Demo223 {
    public static void main(String[] args) {
        //增强for遍历：底层就是迭代器，依旧不要在这个过程中删除元素！
        //所有的单列集合与数组才能用增强for遍历for(元素类型 元素名 ：数组||单列集合名)
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        Collection<String> clt = new ArrayList<>();
        clt.add("爱丽丝");
        clt.add("洛琪希");
        for (String s : clt) {
            System.out.println(s);
        }
    }
}
