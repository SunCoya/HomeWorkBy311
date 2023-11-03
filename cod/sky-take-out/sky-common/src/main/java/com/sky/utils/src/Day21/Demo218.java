package Day21;
import java.util.Arrays;
import java.util.Comparator;
/*
默认快速排序方法反序：只能给引用数据排序
方法：Arrays.sort方法中传入数组与Comparator接口的实现类
泛型类型与数组中的数据保持一致

大致讲一下这个方法底层利用插入排序+二分查找进行排序过程：（没看源码）
遍历无序的序列里面得到每一个元素：把这个元素A插入序列（用二分查找确定插入点）
把A元素与插入点元素进行比较，比较规则就是compare的方法体
返回为负，A走前半，返回大于等于0，A走后半，直到确定A的位置
如果你从小到大排,可以返回A值-B值

这里只需要重写compare函数：
compare形参：o1代表右边遍历的元素A，o2就是左边有序序列中的元素
改变排序结果就只需要：改变o1 o2顺序
*/
public class Demo218 {
    public static void main(String[] args) {
        Integer[] arr = {0,2,5,8,9,6,3,1,4,7};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.print(o1+" "+o2+"  ");
                return o2-o1;
            }
        });
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }
}
