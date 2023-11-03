package Day4;

//switch简化写法：需要JDK12，不需要写break语句
//在需要例举出多个单独情况的时候用switch会简洁很多
public class demo43 {
    public static void main(String[] args) {
        int number = 1;
        switch (number) {
            case 1 -> {
                System.out.println("一");
            }
            case 2 -> {
                System.out.println("二");
            }
            case 3 -> {
                System.out.println("三");
            }
            default -> {
                System.out.println("执行default语句");
            }
        }
        //当case执行的语句只有一条的时候：
        number = 2;
        switch (number) {
            case 1 -> System.out.println("一");
            case 2 -> System.out.println("二");
            case 3 -> System.out.println("三");
            default -> System.out.println("执行default语句");
        }
    }
}
