package Day13.demo132;

import java.util.StringJoiner;
//静态方法的应用：多用在测试类与工具类当中，JavaBean中很少使用，推荐类名调用
//工具类：写工具类辅助自己的程序比如：MathUtils
//对于工具类：1.需要私有化构造方法（外界不能创建该对象）2.方法都定义为静态（static）方法方便调用，且不需要创建对象
public class ArrayUtil {
    private ArrayUtil(){};
    //static别忘加
    public static String printArr(int[] arr){
        StringJoiner sj = new StringJoiner(",","[","]");
        for (int i = 0; i < arr.length; i++) {
            //StringJoiner只能加字符串
            sj.add(arr[i]+"");
        }
        return sj.toString();
    }
    public static double getAverage(double[] arr){
        double sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum/arr.length;
    }
}
