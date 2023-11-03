package Day15.demo159;
/*
成员内部类中的方法对于外部类的成员变量，内部类的成员变量，方法中的变量的调用
在加载字节码文件的时候，这里的代码加载的是两个：
一个是Outer.class，还有一个是Outer&Inner.class，两个字节码文件相互独立
在创建外部类的时候，不会创建内部类的对象！
创建内部类的时候由于必须要创建外部类，所以两个类都需要创建。
在创建内部类的时候，内部类对象的堆空间里面会存储变量，还有一个隐藏的this变量
*/
public class Test {
    public static void main(String[] args) {
        new Outer().new Inner().show();
    }
}
class Outer{
    int a = 10;
    class Inner{
        //在Inner内中会隐藏存储外部类的对象地址Outer this$0;
        int a = 20;
        public void show(){
            int a = 30;
            System.out.println("输出外部类的变量：Outer.this就是获取这个对象的外部类对象的地址值！："+Outer.this.a);
            System.out.println("输出内部类的变量：这里的this记录的是调用者的地址值，也就是内部类的对象："+this.a);
            System.out.println("输出方法内部的变量："+a);
        }
    }
}
