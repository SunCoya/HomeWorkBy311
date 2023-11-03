package Day20;

import java.time.ZoneId;

//JDK8以后新增时间类特点：时间不可变，更安全，更简化。
/*
ZoneID时区
1.如何获取所有时区的数组？
2.如何获取当前系统代表的时区？
3.如何指定时区
*/
public class Demo204 {
    public static void main(String[] args) {
        System.out.println("1.使用静态的getAvailableZoneIds方法获取所有时区");
        System.out.println(ZoneId.getAvailableZoneIds());
        System.out.println("2.使用静态的systemDefault方法获取当前系统默认时区");
        System.out.println(ZoneId.systemDefault());
        System.out.println("3.使用静态的of方法指定时区");
        ZoneId zoneId = ZoneId.of("America/Marigot");
        System.out.println(zoneId);
    }
}
