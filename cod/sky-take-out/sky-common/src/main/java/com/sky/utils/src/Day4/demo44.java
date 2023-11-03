package Day4;
//case后面的数据可以用逗号隔开（多种情况执行相同语句的时候）
public class demo44 {
    public static void main(String[] args) {
        System.out.println("输入整数判断是休息日还是工作日");
        int week = 1;
        switch (week) {
            case 1, 2, 3, 4, 5 -> System.out.println("休息日");
            case 6, 7 -> System.out.println("工作日");
            default -> System.out.println("输入错误");
        }
    }
}
