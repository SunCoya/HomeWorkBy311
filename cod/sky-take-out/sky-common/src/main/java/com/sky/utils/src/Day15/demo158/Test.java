package Day15.demo158;

/*
内部类
类的五大成员：变量，方法，构造方法，代码块，最后一个就是内部类
就是在一个类里面再定义其他的类

比如再ArrayList里面搜索所有成员：
看前面的字母：m是方法，f是变量，c就是内部类

需求：定义JavaBean汽车类：
汽车品牌，年龄，颜色，发动机品牌，使用年限
汽车发动机依赖于汽车，再定义一个发动机类也没有意义，故就在汽车类里面定义就可以咯

内部类的成员变量访问问题：
内部类也可以使用外部类的变量，包括私有
外部类不能使用内部类变量，必须创建对象

成员内部类可以被一些修饰符修饰
使用private修饰内部类，在外界（不是外部类）不能直接创建该对象
(11.2新增：但是可以用它实现接口，然后再到外部创建一个对象，用接口去接收这个对象)
如果使用static修饰内部类，即成为静态内部类，在后面讲解
JDK16以后，成员内部类就能够定义静态变量

获取成员内部类对象方法：
1.外部类成员编写方法来获取(当内部类被private修饰)
2.外部类.内部类 对象名 = new 外部类（）.new 内部类（）（当内部类没有被private修饰）
*/
public class Test {
    public static void main(String[] args) {
        //创建变量名接收内部类对象
        Car.Engine engine = new Car().new Engine();
        //创建外部类对象调用外部类方法
        new Car().show();
        //创建内部类对象调用内部类方法
        new Car().getEngine().show();
    }
}
class Car {
    private String carName;
    private int carAge;
    private int carColor;
    public void show() {
        System.out.println("外部类想要使用内部的成员变量需要创建对象：即使它是私有的也能调用");
        System.out.println("外部类方法创建新的内部类对象在调用其成员变量："+new Engine().engineName);
    }
    public Engine getEngine(){
        return new Engine();
    }
    class Engine {
        static String str = ("JDK16之后，成员内部类里面就可以定义静态变量");
        private String engineName;
        private int engineAge;
        public void show() {
            System.out.println("内部类也可以使用外部类的变量：即使它是私有的"+carName);
            System.out.println("内部类方法调用的本身的成员变量："+engineName);
        }
    }
}

