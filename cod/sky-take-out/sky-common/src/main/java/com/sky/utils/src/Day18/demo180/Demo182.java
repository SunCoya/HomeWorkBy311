package Day18.demo180;
import java.util.Arrays;
/*
System工具类
1.如何返回当前系统时间？计算机中的时间原点是哪一年？1s等于多少毫秒？
2.如何使用工具类拷贝数组，函数传入参数分别是什么？
3.直接退出虚拟机的方法？
*/
public class Demo182 {
    public static void main(String[] args) {
        System.out.println("计算机中的时间原点是1970年（和C语言与Unix系统的诞生有关），1s=1000ms");
        System.out.println("1.使用currentTimeMillis返回当前Long类型系统时间："+System.currentTimeMillis());

        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int[] arr2= new int[10];
        System.out.println("2.使用System.arrayCopy(数组A(数据源)，开始下标，数组B（数据目的地），开始下标，长度)");
        System.out.println("拷贝前的数组："+Arrays.toString(arr2));
        System.arraycopy(arr,7,arr2,2,3);
        System.out.println("拷贝后的数组："+Arrays.toString(arr2));

        System.out.println();
        System.exit(0);
    }
}
