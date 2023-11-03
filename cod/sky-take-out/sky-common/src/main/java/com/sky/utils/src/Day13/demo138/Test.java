package Day13.demo138;

//成员方法：私有不可继承，非私有可继承
/*
    在java中，会从最顶级的方法开始设立虚方法表：用private，final,static修饰的成员方法，不会继承到虚方法表中
    若A继承于B继承于C，那么会从C开始创建虚方法表，再给B创建，再给A创建虚方法表。
    如果代码是这样：A a = new A();
    a.方法c();
    会直接在A类的虚方法表里面找：弹幕有一句话我感觉很对：空间换时间

    当然这里只考虑了private 与 public的情况,对于protect与无修饰符情况没有说明

*/
public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        //调用父类中的public方法：
        son.study();
        son.game();
        //调用父类中的私有方法：报错
        //son.smoke();
    }
}
class Father{
    public void study(){
        System.out.println("会学习");
    }
    private void smoke(){
        System.out.println("会吸烟");
    }
}
class Son extends Father {
    public void game(){
        System.out.println("会打游戏");
    }
}
