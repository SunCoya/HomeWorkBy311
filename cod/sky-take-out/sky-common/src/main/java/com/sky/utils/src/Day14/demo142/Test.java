package Day14.demo142;
//多态中调用成员的特点：
/*
    对于多态在内存中的实现原理老师讲得不是很详细，了解这方面的内存知识可能需要学一学C++吧QwQ，这里只给出了简单的记忆方法：

    变量调用：在用javac编译的时候会看左边的父类中有没有这个成员变量，如果有，编译成功。没有则编译失败
    在调用成员变量的时候实际获取的也是父类的变量

    方法调用：编译看父类中有没有这个方法，没有就报错
    调用成员方法的时候看子类重写的方法：如果子类没有重写那就只能用父类的咯
*/
public class Test {
    public static void main(String[] args) {
        Animal animal = new Dog();
        System.out.println("在多态中：\n父类类型的变量调用其成员变量时总是调用其本类的成员变量");
        System.out.println(animal.name);
        System.out.println("父类类型变量在调用其成员方法时，会优先使用子类重写的方法");
        animal.show();
    }
}
class Animal{
    String name = "父类的成员变量";
    public void show(){
        System.out.println("父类的show方法");
    }
}
class Dog extends Animal{
    String name= "子类的成员变量";
    @Override
    public void show(){
        System.out.println("子类的show方法");
    }
}
