package Day15.demo158;
//外界调用私有内部类中的成员方法（）11.2新增
public class Test2 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Inter inter = outer.getInner1();
        inter.show();
        InnerFather innerFather = outer.getInner2();
        innerFather.show();
        //直接使用outer.getInner().show()是不行的
    }
}
class Outer{
    Inner1 getInner1(){
        return new Inner1();
    }
    Inner2 getInner2(){
        return new Inner2();
    }
    private class Inner1 implements Inter{
        @Override
        public void show() {
            System.out.println("私有内部类的方法，外界可以使用接口接收并调用");
        }
    }
    private class Inner2 extends InnerFather{
        @Override
        public void show() {
            System.out.println("私有内部类的方法，外界可以使用父类接收并调用");
        }
    }
}
interface Inter{
    void show();
}
abstract class InnerFather{
    void show() {}
}
