package Day3;

//三元表达式案例：可以用于替换if else语句
//定义两个数，输出最大的那个数
public class demo38 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int max;
        max = a > b ? a : b;
        System.out.println(max);
    }
}
