package Day20;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/*
ZonedDateTime
1.如何获取当前时间？
2.如何获取指定时间？
3.如何通过ZoneId与Instance获取时间？
4.如何改、增减时间？
*/
public class Demo206 {
    public static void main(String[] args) {
        System.out.println("1.使用静态的方法now获取时间");
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        System.out.println("2.通过静态的of方法获取指定时间对象");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of
                (2023,10,24,15,30,0,0, ZoneId.systemDefault());
        System.out.println(zonedDateTime1);

        System.out.println("3.使用静态的ofInstance方法，通过ZoneId与instant获取对象");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.ofInstant(Instant.now(),ZoneId.systemDefault());
        System.out.println(zonedDateTime2);

        System.out.println("4.使用with改、plus增、minus减时间");
        ZonedDateTime zonedDateTime3 = zonedDateTime2.withYear(2024);
        ZonedDateTime zonedDateTime4 = zonedDateTime3.minusYears(1);
        ZonedDateTime zonedDateTime5 = zonedDateTime4.plusYears(1);
        System.out.println(zonedDateTime5);
    }
}
