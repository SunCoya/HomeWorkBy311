package Day15.demo1511;
/*
局部内部类：在方法里面定义的类.
1.方法外面不能访问该类，也不能够创建该类的对象：就像不能访问方法里面的局部变量一样
2.方法中使用局部内部类里面的成员需要先创建对象
3.局部内部类可以访问方法外的变量与方法内部的成员变量
以上这些也是通过Java方法中的成员的内存原理去理解就好
 */
public class Test {
    public static void main(String[] args) {
        new Outer().show();
    }
}
class Outer{
    String str2= "方法外的变量";
    public void show(){
        String str1 = "方法内的变量";
        class Inner{
            String str = "方法里面的局部内部类的成员变量";
            void show(){
                System.out.println("方法里面的局部内部类的成员方法");
                System.out.println("可以调用"+str1+"与"+str2);
            }
        }
        Inner inner=new Inner();
        System.out.println("需要在方法里面创建对象才能够调用方法里面的变量"+inner.str);
        inner.show();
    }
}

