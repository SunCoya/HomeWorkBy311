package Day15.demo1510;
/*
在外界创建静态内部类对象
静态内部类对外部类对象与方法的访问
外界调用静态内部类方法
其实核心还是对于静态修饰的成员在内存中的原理：这些成员会随类名加载，理解这个下面的就很容易看懂了，不要死记硬背
*/
public class Test {
    public static void main(String[] args) {
        //创建静态内部类的对象：因为是静态的成员：只用外部类名就能调用静态内部类（不需要像上面的成员内部类对象一样先创建外部类对象）。
        Outer.Inner inner = new Outer.Inner();
        //调用静态内部类中的非静态方法:需要创建对象
        inner.show();
        //调用静态内部类的静态方法：直接调用即可
        Outer.Inner.staticShow();
    }
}
class Outer{
    static String  a = "外部类的静态变量";
    String b = "外部类的非静态变量";
    static class Inner{
        void show(){
            System.out.println("静态类中的非静态方法");
            System.out.println("静态内部类中，对于外部类：只能访问外部类当中的静态变量与方法，不能访问外部类非静态成员："+a);
            System.out.println("创建在内部类中创建外部类的对象以访问外部类的非静态变量与方法："+new Outer().b);
        }
        static void staticShow (){
            System.out.println("静态类中的静态方法");
        }
    }
}

