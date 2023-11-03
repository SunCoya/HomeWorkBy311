package Day15.demo155;
/*
接口中的的私有方法
在以前说过，如果多个类中有重复的代码，一般把这段代码单独分离出来，并设置成private
接口中的私有方法定义格式：
普通的案例：private void show(){}(注意这里不用加default，因为这个方法就是给default修饰的方法服务的)
静态的案例：private static void method(){}(和上面的那个一样，这个方法就是为public的静态方法服务的)
*/
public class Test {
    public static void main(String[] args) {
        InterImpl interImpl = new InterImpl();
        interImpl.show1();
        interImpl.show2();
    }
}
class InterImpl implements Inter{

}
interface Inter{
    default void show1(){
        System.out.println("default修饰的第一个方法");
        privateShow();
    }
    default void show2(){
        System.out.println("default修饰的第二个方法");
        privateShow();
    }
    private void privateShow(){
        System.out.println("private修饰的普通方法，为default方法中的重复代码服务");
    }

    private static void privateStaticShow(){
        System.out.println("private修饰的static方法，为public static中的重复代码服务");
    }
}
