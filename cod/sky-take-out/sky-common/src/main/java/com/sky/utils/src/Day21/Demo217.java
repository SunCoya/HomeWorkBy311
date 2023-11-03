package Day21;

import java.util.Arrays;

/*
Arrays类
1.如何拷贝数组返回一个新数组？(区别于System.arrayCopy)
2.如果传入数组参数后再传一个参数和两个参数分别代表什么？
3.如何把数组中所有值设置为一个固定值？
4.如何排序数组？
5.如何指定范围排序数组？
*/

public class Demo217 {
    public static void main(String[] args) {
        int[] arr = {1,2,5,8,7,4,6,9,0,3};
        System.out.println("1.拷贝数组，返回新数组,可以不用自己创建新数组复制了，数组越界补默认值");
        System.out.println(Arrays.toString(Arrays.copyOf(arr,arr.length)));

        System.out.println("2.拷贝指定坐标数组，返回新数组（包头不包尾）, 数组越界补默认值");
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,6,15)));

        System.out.println("3.填充数组");
        int[] arr1 = new int[10];
        Arrays.fill(arr1,6);
        System.out.println(Arrays.toString(arr1));

        System.out.println("4.排序数组,默认排序:双轴快速排序,比传统快排更快");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("5.指定排序方式:指定下标排序");
        int[] arr2 = {1,2,5,8,7,4,6,9,0,3};
        Arrays.sort(arr2,0,5);
        System.out.println(Arrays.toString(arr2));
    }
}
