package Day5;

//数组的定义与初始化:
public class demo52 {
    public static void main(String[] args) {
        //定义数组的两种方式；
        int[] array;//常用格式
        int array2[];
        //静态初始化：一旦初始化数组，不能够改变它的长度
        array = new int[]{1, 2, 3, 4, 5};

        //静态初始化简化的书写格式：必须要定义与初始化在一起才能这么写
        // 如果先定义，后初始化，如：array2={......}是不行的
        int[] array3 = {1, 2, 3, 4, 5};

        //动态初始化：创建一定大小的数组，数组中所有数初始化为0
        int[] array4 = new int[5];
        for (int i = 0; i < array4.length; i++) {
            System.out.print(array4[i]);
        }

    }
}
