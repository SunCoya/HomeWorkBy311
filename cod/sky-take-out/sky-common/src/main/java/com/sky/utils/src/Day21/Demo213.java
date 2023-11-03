package Day21;
import java.util.Arrays;
//选择排序
//从0索引开始与后面的元素比较，小的放前面，大的放后面，确定数字的顺序是从前往后确定的
public class Demo213 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 4, 0, 3, 6, 9, 8, 7};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void selectionSort(int[] arr) {
        System.out.println("第一层循环确定循环次数<length-1次");
        System.out.println("第二层循环i确定比较元素I（守馆人），j确定比较元素J(踢馆选手)");
        System.out.println("j不需要设置成i，初始值设置为i+1，j最大值到数组最后");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}