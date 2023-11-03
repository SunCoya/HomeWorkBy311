package Day20;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
/*
Instance时间戳（相当于没有时区的Date类）
1.如何获取当前时间的instant对象？默认是系统时间还是标准时间？
2.如何设置指定时间的instant对象？
3.如何指定时区,返回ZoneDateTime（相当于Date类）？
4.如何方法比较时间戳，判断时间先后？
5.如何使用增减时间?
*/
public class Demo205 {
    public static void main(String[] args) {
        System.out.println("1.使用静态方法now()获取当前时间的instant对象(默认标准时间)");
        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println("2.根据ofEpochMilli()方法设置豪秒获得时间的instant对象");
        instant = Instant.ofEpochMilli(1L);
        System.out.println(instant);

        System.out.println("3.使用atZone方法指定时区,返回ZoneDateTime（相当于Date类）");
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        System.out.println("4.使用静态的isbefore方法与isafter方法比较时间戳，判断时间先后");
        Instant instant1 = Instant.ofEpochMilli(0);
        Instant instant2 = Instant.ofEpochMilli(1000);
        System.out.println(instant1.isBefore(instant2));
        System.out.println(instant2.isAfter(instant1));

        System.out.println("5.使用minus与plus增减时间");
        Instant instant3 = instant2.minusSeconds(1);
        Instant instant4 = instant1.plusSeconds(1);
        System.out.println(instant3);
        System.out.println(instant4);
    }
}
