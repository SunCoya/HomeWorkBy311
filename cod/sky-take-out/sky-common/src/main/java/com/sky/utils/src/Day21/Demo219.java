package Day21;
import java.util.Arrays;
import java.util.Comparator;
/*
    lambda表达式：最基本的特点：简化匿名内部类的书写(JDK8后出现)
    函数式编程Function Programing：忽略面向对象的复杂语法：强调做什么，而不是谁去做
    注意：lambda表达式：只能简化函数式接口（只有一个抽象方法的接口，可以加@FunctionalInterface）的匿名内部类，不能简化抽象类。
    格式：()->{}
*/
public class Demo219 {
    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Arrays.sort(arr, (Integer o1, Integer o2) -> {
            return o1 - o2;
        });
        Arrays.sort(arr, (o1, o2) -> o1 - o2);
    }
}
