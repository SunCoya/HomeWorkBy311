package Day20;

import java.util.Calendar;
import java.util.Date;

/*
Calendar代表日历对象，可单独修改年月日，解决日期表达与变动复杂的问题
1.如何获取Calendar对象？
2.Calendar类中如何表示月份？（特殊情况）
3.Calendar中如何表示时间？（特殊情况）
4.如何设置Calendar时间？
5.如何获取Calendar所表示的时间？
6.如何使用Calendar输出日期？
7.如何修改日期信息？
8.如何增加或者减少日期？
 */

public class Demo203 {
    public static void main(String[] args) {
        System.out.println("1.这个类是抽象类，不能创建对象，只能用其静态方法获取其子类对象");
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println("2.如果是月份：范围是0-11，需要在获取到月份基础上+1");
        System.out.println("3.如果是星期：1代表星期日，2代表星期一，以此往后推");

        System.out.println("4.通过setTime设置时间(通过两种方式：setDate与毫秒值)");
        calendar.setTimeInMillis(0);
        calendar.setTime(new Date());

        System.out.println("5.通过getTime获取时间（Date与毫秒值）");
        System.out.println(calendar.getTimeInMillis());
        System.out.println(calendar.getTime());


        System.out.println("6.使用Calendar输出现在的日期，并且输出星期，通过get方法传入不同参数获取不同数据");
        System.out.println("改进点：定义有序数组存储数据，能够对应不同输出");
        char[] chars = {'日', '一', '二', '三', '四', '五', '六'};
        System.out.println(calendar.get(Calendar.YEAR) + "年" +
                (calendar.get(Calendar.MONTH) + 1) + "月" +
                calendar.get(Calendar.DATE) + "日" +
                " " + "星期" + chars[calendar.get(Calendar.DAY_OF_WEEK)-1]);

        System.out.println("7.通过set方法修改日期信息,可以看看消息提示看看能够传入那些信息（方法的重载）");
        calendar.set(2021,Calendar.OCTOBER,16);
        calendar.set(Calendar.YEAR,2024);
        System.out.println(calendar.get(Calendar.YEAR) + "年" +
                (calendar.get(Calendar.MONTH) + 1) + "月" +
                calendar.get(Calendar.DATE) + "日" +
                " " + "星期" + chars[calendar.get(Calendar.DAY_OF_WEEK)-1]);

        System.out.println("8.通过add方法增加日期,负数为减少日期");
        calendar.add(Calendar.DATE,80);
        System.out.println(calendar.get(Calendar.YEAR) + "年" +
                (calendar.get(Calendar.MONTH) + 1) + "月" +
                calendar.get(Calendar.DATE) + "日" +
                " " + "星期" + chars[calendar.get(Calendar.DAY_OF_WEEK)-1]);
    }
}
