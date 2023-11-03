package Day20;

import java.time.*;
/*
Local  Date|Time|DateTime(日期，时间，时间日期一起)：日历类
1.如何创建改对象？
2.如何指定时间创建对象？
3.如何获取属性？
4.如何比较时间
5.如何改动，增删时间？
6.如何把LocalDateTime转变成其他的两个类的对象？
7.什么方法能够判断是否为闰年？
8.使用MonthDay判断今天是否为生日的案例
*/

public class Demo208 {
    public static void main(String[] args) {
        System.out.println("1.使用静态的方法now创建对象");
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        System.out.println("2.使用静态的方法of指定时间创建对象");
        LocalDateTime ldt1 = LocalDateTime.of(2024,10,24,15,50,20);
        System.out.println(ldt1);

        System.out.println("3.通过get获取属性(在这里month与dayOfWeek都是类)：");
        System.out.println("获取月份："+ldt.getMonth().getValue());
        System.out.println("获取星期："+ldt.getDayOfWeek().getValue());

        System.out.println("4.通过isAfter,isBefore比较时间");
        System.out.println(ldt.isAfter(ldt1));

        System.out.println("5.通过with，plus，minus修改增加减少");
        LocalDateTime ldt2 = ldt1.withYear(2025);
        LocalDateTime ldt3 = ldt1.plusYears(1);
        LocalDateTime ldt4 = ldt1.minusYears(1);

        System.out.println("6.使用toLocal...向下兼容转换");
        LocalDate ld = ldt1.toLocalDate();
        LocalTime lt = ldt1.toLocalTime();
        System.out.println(ld+" "+lt);

        System.out.println("7.使用isLeapYear判断是否为闰年");
        System.out.println(ld.isLeapYear());

        System.out.println("8.案例，判断是否为生日，使用到了MonthDay对象");
        LocalDate localDate = LocalDate.now();
        MonthDay md = MonthDay.from(localDate);
        System.out.println(md);
        MonthDay birthday = MonthDay.of(2,20);
        if (md.equals(birthday)){
            System.out.println("生日快乐");
        }else {
            System.out.println("不生日也快乐");
        }
    }
}
