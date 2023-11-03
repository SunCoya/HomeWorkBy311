package Day15.demo153;
/*
对于接口中的所有成员变量：默认使用public static final修饰

在JDk7以前，接口中只能定义抽象方法
到JDK8之后，接口中就可以定义有方法体的方法：（默认与静态方法）
JDK9以后就可以用private修饰方法

本案例演示默认方法：
父类中能够定义方法让其实现类继承，接口中也应该这样
接口升级：添加接口方法，这个时候实现类不需要立马修改，用到规则再重写就行，可以使用default方法
在接口中定义，需要用default修饰（不是什么都不写）
定义default方法的格式：
public default void show（）不写public也会默认public
该方法不强制被重写：如果重写就在其实现类中去掉default
如果实现多个接口，这些接口中存在名字相同的default方法，就需要重写防止混淆
*/
public class Test {
    public static void main(String[] args) {
        InterImpl interImpl = new InterImpl();
        interImpl.method();
        interImpl.show();
    }
}
class InterImpl implements Inter1,Inter2{
    @Override
    public void method(){
        System.out.println("抽象方法需要被重写");
    }
    @Override
    public void show() {
        //IDEA自动生成调用某个接口的方法，这里一定要指定接口名
        Inter2.super.show();
    }
}
interface Inter1{
    void method();//接口里面不写修饰符默认用public abstract修饰                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              什么都不写就是隐式指定public abstract
    default void show(){
        System.out.println("这个是接口中的default方法,不需要强制重写");
    }
}
interface Inter2{
    default void show(){
        System.out.println("这个是接口中的default方法,不需要强制重写，除非实现的多个接口中有相同的方法名");
    }
}
