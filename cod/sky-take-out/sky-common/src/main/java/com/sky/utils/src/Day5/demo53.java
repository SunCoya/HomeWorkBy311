package Day5;

//输出数组名：数组容器在内存中的地址值
public class demo53 {
    public static void main(String[] args) {
        //动态初始化数组以及初始化值
        boolean[] array1 = new boolean[3];
        byte[] array2 = new byte[3];
        short[] array3 = new short[3];
        int[] array4 = new int[3];
        long[] array5 = new long[3];
        float[] array6 = new float[3];
        double[] array7 = new double[3];
        String[] array8 = new String[3];
        /*
        输出的格式：
        [           :代表这是一个数组
        I           :代表当前数组元素是int类型的
        @           :间隔符号
        后面的数字    :数组地址值
         */
        System.out.println(array1);
        System.out.println(array2);
        System.out.println(array3);
        System.out.println(array4);
        System.out.println(array5);
        System.out.println(array6);
        System.out.println(array7);
        System.out.println(array8);

        //动态初始值：
        System.out.println("boolean类型初始值：" + array1[0]);
        System.out.println("byte类型初始值：" + array2[0]);
        System.out.println("short类型初始值：" + array3[0]);
        System.out.println("int类型初始值：" + array4[0]);
        System.out.println("long类型初始值：" + array5[0]);
        System.out.println("float类型初始值：" + array6[0]);
        System.out.println("double类型初始值：" + array7[0]);
        System.out.println("String类型初始值：" + array8[0]);
    }
}
