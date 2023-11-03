package Day5;

//在Java如何在for循环的初始条件中一次定义两个数
public class demo54 {
    public static void main(String[] args) {
        int a = 0, b = 1;
        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.print(i + " " + j + " ");
        }
    }
}
