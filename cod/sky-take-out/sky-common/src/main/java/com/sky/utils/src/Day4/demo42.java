package Day4;

// case穿透：一般匹配到的case中没加break语句时，那就会执行匹配到的case里面的语句，以及这个switch中，该case下面的所有语句。直到遇到break为止
public class demo42 {
    public static void main(String[] args) {
        String a = "2";
        switch (a) {
            case "1":
                System.out.println(1);
                break;
            case "2":
                System.out.println("2：没有加break语句，执行下一句");
            default:
                System.out.println("default：这是default代码块：没有加break语句，执行下一句");
            case "3":
                System.out.println("3:在此case内加入了break语句，停止执行。");
                break;
            case "4":
                System.out.println(4);
                break;
        }
    }
}
