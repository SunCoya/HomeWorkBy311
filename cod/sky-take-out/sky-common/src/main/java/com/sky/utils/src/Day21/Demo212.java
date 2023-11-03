package Day21;
import java.util.Arrays;
//冒泡排序
//每过一遍数组,比较相邻两个数确定一个数放到最后面即可,大的往后靠
public class Demo212 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 4, 0, 3, 6, 9, 8, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void bubbleSort(int[] arr) {
        System.out.println("第一层循环：循环数组长度次数-1即可：10个数据，循环9次能确定9个数的位置，最后一个就不用循环了");
        System.out.println("第二层循环：每次循环减少一个排序目标，故减去i,循环内部i与i+1比较，再减一保证数组不越界");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}