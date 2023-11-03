package Day13.demo136;

/*子类能够继承父类中的哪一些内容？
1.构造方法：无法继承
2.成员变量：全部继承
3.成员方法：private不能继承，非私有能够继承

1.为什么构造方法不能继承呢？如果父类Animal的构造方法叫Animal（），子类Cat的构造方法如果继承，是不是也只能够叫Animal了？
所以子类的构造方法要自己写！
2.父类用private修饰成员变量，子类不能直接拿来使用，要通过GetSet方法*/
public class demo136 {
    public static void main(String[] args) {
        Son son =new Son();
    }
}
class Father {
    String name;
    int age;
    public Father(){};
    public Father(String name,int age){
        this.name=name;
        this.age=age;
    }
}
class Son extends Father{
    public Son() { }
    public Son(String name, int age) {
        super(name, age);
    }
}
