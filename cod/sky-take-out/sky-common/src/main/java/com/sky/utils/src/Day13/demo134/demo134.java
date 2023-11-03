package Day13.demo134;

public class demo134 {
    public static void main(String[] args) {
        //public：被JVM调用，访问权限足够大
        //static：直接类名访问，不需要创建对象，因为main方法是静态的，测试类中的其他方法也需要是静态的
        //void: 被JVM调用，不需要返回值
        //main: 只有main才能被虚拟机识别
        //String[] args：用于接收键盘录入数据，为了向下兼容，现在仍然保留：这是字符串数组,默认情况下没有数据
        System.out.println("IDEA中右上角EditConfigurations中可以设置字符串数组内容");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
