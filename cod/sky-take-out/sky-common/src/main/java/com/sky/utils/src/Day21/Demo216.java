package Day21;
import java.util.Arrays;
import java.util.Random;
//快速排序
//第一轮：把0索引作为中标，移动之后，中标的左边都是比他小的，右边都是比它大的
//怎么做呢？设置左右标，右标向左找比中标小的，逮到了一个就停，那么左标就找比右标大的，逮到了就停下
//然后做什么事情就知道了：交换左右标上面的数字，左右标继续移动找人
//直到他们相等，相等之后，把第一个基准数与重合的地方的数字交换就可以了（基准数归位）
//接下来就按上面的方法排序基准数左边的数字与右边的数字
public class Demo216 {
    public static void main(String[] args) {
        int[] arr = new int[50];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //1.创建函数，参数：数组，开始索引，结束索引
    public static void quickSort(int[] arr, int start, int end) {
        //2.结束条件：start>=end就不排
        if (start >= end) return;

        //3.创建左右标与基准数
        int i = start;
        int j = end;
        int mid = arr[i];

        //4.开始循环
        while (i != j) {
            //注意点一：
            //必须是先移动j再移动i：先移动i有可能把i撞到比mid大的数上去，而重合的地方又需要和基准数交换，
            //而先移动j，停下来就两种情况：碰到i或者碰到比它小的
            //第一种情况，重合，肯定能与基准数交换（i从0索引开始）
            //第二种情况：等着i拥入怀里到来就可以了

            //注意点二：
            //这里这一个等于条件：等于就不管它，反正后面的会接着排号的
            //如果这里没有写等于：如碰到i,j都碰到两个等于mid的数：死循环就来了

            //5.移动左右标，寻找数字
            while (arr[j] >= mid && i != j) {
                j--;
            }
            while (arr[i] <= mid && i != j) {
                i++;
            }

            //6.交换数字
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //7.把第一个数设置为左右标重合的那个数，把左右标重合那个数设置为基准数
        arr[start] = arr[i];
        arr[i] = mid;

        //注意点三：这里如果设置成i-1，有可能造成i-1<start的问题,在方法开始加一个结束条件即可
        //8.开始递归
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
}
