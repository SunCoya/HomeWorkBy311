package Day21;

import java.util.Arrays;
//插入排序
//把前面的数字看作有序，把后面的数字看作无序，把后面的数据一个一个放到前面的有序数组中
public class Demo214 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 4, 0, 3, 6, 9, 8, 7};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void insertionSort(int[] arr) {
        System.out.println("1.寻找找开始下标，排除数组已经全部排好的情况");
        int startIndex  = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]>arr[i+1]){
                startIndex = i+1;
                break;
            }
        }
        if (startIndex == 0) startIndex=arr.length;

        System.out.println("2.开始在下标："+startIndex+"搜索，从index-length-1的数据全拿来，i为要插入的数据");
        for (int i = startIndex; i < arr.length ; i++) {
            //记录num，记录j为：被选中的数字应该插入的索引
            int j = i;
            int num = arr[i];
            //这里的循环意义是：比较前面一个数是否比要插入的数据大，如果大就把前面的数据往后搬
            //否则此处就是正确的位置，停下来插入，j能够记录下num应该插入的地方（当然也可以定义第三个参数交换位置一步一步挪）
            //在循环外面插入数据即可
            while (j > 0 && arr[j-1]>num) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = num;
        }
    }
}