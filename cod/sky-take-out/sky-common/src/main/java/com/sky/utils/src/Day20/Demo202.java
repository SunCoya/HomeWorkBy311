package Day20;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
SimpleDateFormat:Date——字符串转换器
1.空参构造与有参构造的区别？
2.使用什么方法能把Date转变为字符串？
3.有参构造如何代表年月日时分秒？
4.使用什么方法把字符串转变为Date?
*/
public class Demo202 {
    public static void main(String[] args) throws ParseException{
        System.out.println("1.创建这个对象的时候，默认为Java的时间表示形式，传入字符串就用您字符串的表现形式");
        //无参构造
        SimpleDateFormat sdf1 = new SimpleDateFormat();

        System.out.println("2.使用format方法格式化日期，转换为字符串。");
        System.out.println(sdf1.format(new Date()));


        System.out.println("3.字符串对应年月日时分秒（分大小写）：yMdHms，只有小时和月份是大写如：\"yyyy年MM月dd日 HH:mm:ss\"：老师的说法是：大MM小dd哈哈哈哈哈哈");
        //有参构造
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf2.format(new Date()));
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EE");
        System.out.println(sdf3.format(new Date()));

        System.out.println("4.使用parse方法解析字符串，把字符串变成Date对象");
        String str = "2023-11-11 11:11:11";
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf4.parse(str);
        System.out.println(date);
    }
}
