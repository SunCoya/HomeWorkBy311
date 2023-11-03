package Day15.demo154;

/*
接口中的静态方法（前面两个学的是无修饰的接口方法(方法里面不能有内容)与default修饰的接口方法）
接口中的静态方法只能通过类名调用
（当然一般类中也只推荐使用类名调用，但是也能够通过对象调用(不把构造方法私有化)，这里接口由于不能实例化对象，所以无法通过对象调用）
接口中的静态方法格式：
例如：public static void show(){},不写public也会默认public
*/
public class Test {
    public static void main(String[] args) {
        Inter.show();
        InterImpl.show();
    }
}
class InterImpl implements Inter{
    //静态方法不能够被重写，无论是实现类（实现接口中有静态方法）还是子类（父类中有静态方法）
    //不写@Override的话也不会报错：这只是这个类与接口中有重名的方法,这不叫重写
    //以前也说了，重写是重写虚方法表中的，static，final，private不会被重写
    //子类能够继承并且调用父类的静态方法，但是实现类不能调用接口中的static方法！只能用default！这两个修饰符不能够放一起写
    public static void show(){
        System.out.println("接口的实现类中的静态方法：与接口中的静态方法没有关联");
    }
}
interface Inter{
    static void show(){
        System.out.println("接口中的静态方法");
    }
}
