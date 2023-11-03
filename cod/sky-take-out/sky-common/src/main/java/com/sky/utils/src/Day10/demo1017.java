package Day10;
import java.util.Scanner;
//键盘录入字符串，输出罗马数字
public class demo1017 {
    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        boolean flag;
        while (true) {
            flag = true;
            System.out.println("请输入字符串");
            str = scanner.next();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                    System.out.println("字符串中只能存在数字！");
                    flag = false;
                    break;
                }
            }
            if (flag)
                break;
        }
        char[] chars = {' ', 'Ⅰ', 'Ⅱ', 'Ⅲ', 'Ⅳ', 'Ⅴ', 'Ⅵ', 'Ⅶ', 'Ⅷ', 'Ⅸ'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(chars[str.charAt(i) - '0']);
        }
        System.out.println(sb);
    }
}
