package Day13.demo137;

//继承在内存中的原理:
/*
    在子类字节码文件加载到方法区的时候，会识别继承的父类，并且把父类字节码文件也加载到方法区
    在new一个子类对象的时候：继承成员变量：分别记录自己的成员变量和父类的成员变量
    如果说父类中使用private修饰成员变量：子类中不能直接调用从父类中继承下来的成员变量
*/
public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        son.name="儿子";
        son.age=20;
        son.game="上古卷轴五";
        //不能使用的父类的私有成员变量比如：
        //son.smoke="华子";
    }
}
class Father {
    public String name;
    public int age;
    private String smoke;
}
class Son extends Father{
    public String game;
}
