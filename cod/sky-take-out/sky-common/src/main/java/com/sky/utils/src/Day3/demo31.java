package Day3;

//如果在计算中有小数参与，计算结果有可能不精确的案例:
public class demo31 {
    public static void main(String[] args) {
        System.out.println("两个小数相加的不精确结果：");
        System.out.println(1.1 + 1.01);
        //取余也能用在浮点数上面
        System.out.println("小数取余的不精确结果：");
        System.out.println(3.01 % 2);
    }
}
