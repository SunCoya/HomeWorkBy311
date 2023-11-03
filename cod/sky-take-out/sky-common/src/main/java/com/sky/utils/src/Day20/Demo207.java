package Day20;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
//DateTimeFormatter(相当于SimpleDateFormat)
//如何创建对象？
public class Demo207 {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("创建方法：使用静态的ofPattern方法");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EE a");
        //把时间转换为字符串
        String str = dtf.format(zdt);
        System.out.println(str);
    }
}
