package Day15.demo156;
/*
接口的应用：
如果说有搬家方法：moveHome（Car car）
这个方法里面能放car和car的一切子类的对象
但是不能放人，或者说是搬家公司，按照之前的知识，那我只能够有多少种搬家的工具，我就要写多少方法，很麻烦
从逻辑上来讲也不能够让人，car，搬家公司继承于同一个特定父类，要的不是一个继承体系，而是遵循一种特定的功能
这时候就可以定义运输的接口，这样搬家方法就变成了moveHome（接口 interface），接口就是对行为的抽象
这样，就能够把接口的实现类（车，人，搬家公司）全部传递到moveHome里面去，这个就叫做接口多态
就像Father father = new Son();一样
接口中，也能够这样写,用实现类创建对象：Inter inter = new InterImpl();
调用方法的时候也同样遵守：编译看左边，实现看右边的原则


*/
public class Test {
    public static void main(String[] args) {
        System.out.println("运用多态，调用Car类对象中实现接口的方法");
        new Home().moveHome(new Car());
    }
}
class Home{
    void moveHome(Inter inter){
        inter.show();
    }
}
interface Inter{
    public static final String name = "搬家行为的接口";
    void show();
}
class Car implements Inter{
    @Override
    public void show() {
        System.out.println("汽车搬家");
    }
}
class Human implements Inter{
    @Override
    public void show() {
        System.out.println("人力搬家");
    }
}
