package Day20;
import java.util.Date;
/*
Date类
1.空参构造Date对象代表队时间是？
2，如何获取和改变Date对象的时间？
3.如何输出时间原点后过一年的时间？set时间值需要注意什么？
*/
public class Demo201 {
    public static void main(String[] args) {
        System.out.println("1.空参构造表示当前系统时间，有参构表示造指定时间");
        Date date1 = new Date();
        System.out.println(date1);
        Date date2 = new Date(0L);
        System.out.println(date2);

        System.out.println("2.通过get与set方法获取和变时间");
        date2.setTime(date1.getTime());
        System.out.println(date2);

        System.out.println("3.打印时间原点开始一年之后的时间:注意加L表示Long类型，不然会越界int类型，过一年就315亿了。");
        System.out.println(new Date(1000L * 60 * 60 * 24 * 365));
    }
}
