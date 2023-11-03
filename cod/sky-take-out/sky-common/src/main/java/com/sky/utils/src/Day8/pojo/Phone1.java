package Day8.pojo;
//方法定义不加static的原因：main函数在没有实例化对象的时候不能调用非静态方法，这里因为会实例化phone，故可以写非静态方法。
//描述一类事物的类叫做Javabean类，可以编写属性（成员变量）与行为（成员方法），不含main方法
//一个代码文件中可以有多个类，但是用public修饰的只能是一个类，且该类名必须是代码文件名,建议一个Java文件中只写一个类
public class Phone1 {
    public String brand;
    public double price;
    public void call(){
        System.out.println("手机打电话");
    }
    public void playGame(){
        System.out.println("口袋妖怪，启动！");
    }
    public static void staticMethod(){
        System.out.println("不创建对象但是可以调用对象的静态方法");
    }
}
