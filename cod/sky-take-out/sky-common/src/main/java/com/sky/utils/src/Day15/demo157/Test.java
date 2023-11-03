package Day15.demo157;
/*
适配器设计模式：用来解决接口与接口实现类之间的矛盾问题
在接口中如果有10个抽象方法：而现在我只要用实现类实现第一个抽象方法，其他的不需要，但是这样的话我就要重写其他的抽象方法。
有一种解决办法：就是创建一个类（这个类就是适配器，一般设置为抽象类，不让外界创建对象）实现接口：但是实现的方法里面全部空着不写
想要创建实现类调用方法的时候，这个类继承适配器就可以了，这样就可以重写其中某一个方法就能够使用这个类了

但是我认为这里还有一种可能，就是全写成default修饰然后里面全写空也能做到。
这里老师讲的比较浅，只是了解”适配器模式“即可
 */

public class Test {
}
class InterImpl extends InterAdapter{
    //在这个类当中用到哪个方法就重写什么方法，如果这个类还有继承的其他类(如Animal)，可以让适配器继承那个类Animal
    @Override
    public void method1(){
        System.out.println("只用重写一个方法即可");
    }
}
abstract class InterAdapter implements Inter{
//在这个类当中实现所有方法的空方法：设置成抽象类，不需要让外界创建该类对象
    @Override
    public void method1() {
    }
    @Override
    public void method2() {
    }
    @Override
    public void method3() {
    }
    @Override
    public void method4() {
    }
    @Override
    public void method5() {
    }
}
interface Inter{
    void method1();
    void method2();
    void method3();
    void method4();
    void method5();
}
