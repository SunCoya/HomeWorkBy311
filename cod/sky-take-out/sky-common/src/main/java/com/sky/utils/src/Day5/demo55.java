package Day5;

//Java中的数组内存分配：
//数组是存储在堆内存（用new来创建的变量）的，在方法里面需要调用数组的地址来进行使用
public class demo55 {
    public static void main(String[] args) {
        int[] array1 = new int[1];
        int[] array2 = array1;//相当于地址赋值，两个变量用到的是同一个地址
        System.out.println(array1[0]);
        System.out.println(array2[0]);
        System.out.println(array1);
        System.out.println(array2);
        array1[0] = 1;//array1变化，array2也跟着变化
        System.out.println(array1[0]);
        System.out.println(array2[0]);
    }
}
