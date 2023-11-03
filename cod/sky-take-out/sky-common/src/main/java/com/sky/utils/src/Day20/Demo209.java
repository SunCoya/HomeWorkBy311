package Day20;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/*
时间工具类：得到时间间隔
Period（年月 ）Duration（天小时分秒） ChronoUnit（全）
1.如何使用工具类判断日期，年份，月份的间隔？
2.如何输出数据？
3.Period类在创建对象时与Duration类有什么不一样？
4.如何使用ChronoUnit工具类获取时间不同间隔
*/
public class Demo209 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate birth  = LocalDate.of(2003,6,28);

        System.out.println("1.使用静态方法between获取period对象");
        Period period = Period.between(birth,localDate);
        System.out.println("2.输数据：输出年月日，输出总间隔月份");
        System.out.println(period);
        System.out.println(period.getYears()+"年"+period.getMonths()+"月"+period.getDays()+"日");
        System.out.println(period.toTotalMonths()+"月");


        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime birthday  = LocalDateTime.of(2003,6,28,0,0,0);
        System.out.println("3.使用静态方法between获取period对象，这里不能传LocalDate对象");
        Duration duration = Duration.between(birthday,localDateTime);
        System.out.println(duration);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toSeconds());
        System.out.println(duration.toMillis());


        System.out.println("4.使用ChronoUnit.时间单位.between方法获取时间间隔");
        System.out.println(ChronoUnit.YEARS.between(birthday,localDateTime));
        System.out.println(ChronoUnit.MONTHS.between(birthday,localDateTime));
        System.out.println(ChronoUnit.WEEKS.between(birthday,localDateTime));
        System.out.println(ChronoUnit.DAYS.between(birthday,localDateTime));
        System.out.println(ChronoUnit.HOURS.between(birthday,localDateTime));
        System.out.println(ChronoUnit.MINUTES.between(birthday,localDateTime));
        System.out.println(ChronoUnit.SECONDS.between(birthday,localDateTime));
        System.out.println(ChronoUnit.MILLIS.between(birthday,localDateTime));

        System.out.println(ChronoUnit.HALF_DAYS.between(birthday,localDateTime));
        System.out.println(ChronoUnit.DECADES.between(birthday,localDateTime));
        System.out.println(ChronoUnit.CENTURIES.between(birthday,localDateTime));//世纪
        System.out.println(ChronoUnit.MILLENNIA.between(birthday,localDateTime));//千年
        System.out.println(ChronoUnit.ERAS.between(birthday,localDateTime));//纪元
    }
}
