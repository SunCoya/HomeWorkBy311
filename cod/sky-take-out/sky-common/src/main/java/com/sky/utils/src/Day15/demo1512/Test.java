package Day15.demo1512;
/*
匿名内部类：没有类名的类！
new 类名/接口名{
    @Override
    重写的方法();
};
可以对比  有名字的类实现 与 匿名内部类中的实现
看看有什么不一样的地方

在这里匿名内部类相当于new了一个类的对象：这个类能实现接口里面的方法
new接口名，然后再到匿名内部类里面实现抽象方法
这样做的好处就是可以直接创建一个新的类，然后立马就能用，不用再去重新封装类去继承或者实现了

在下列案例中
在工程文件里面的out\production\JAVA基础\Day15\demo1512可以找到字节码文件：可以发现Test$的三个内部类
javap（命令行中）可以反编译.class文件（Java自带）：可以看到每个类里面都有重写的方法（你自己实现的）与无参构造方法

匿名内部类，可以写在成员位置（如main方法外,这个就是成员内部类中的一种），可以写在局部位置（如main方法内，就可以算是局部内部类中的一种）
*/
public class Test {
    static Swim swim = new Swim() {
        @Override
        public void swim() {
            System.out.println("写在成员位置的匿名内部类");
        }
    };
    public static void main(String[] args) {
        Swim swim = new Swim() {
            @Override
            public void swim() {
                System.out.println("在匿名内部类里面实现接口里面的抽象方法");
            }
            public void swim2() {
                System.out.println("在匿名内部类里面新增自己的方法");
            }
        };
        //多态
        //如果用接口定义变量：如果选择不用接口变量接收对象，就可以调用匿名内部类里面的所有方法
        //如果说定义了接口变量接收对象，那么这个对象只能调用swim方法，不能调用自己新增的方法
        //在这里是不能调用Swim2的：因为这里的变量使用接口去定义的，要先看接口中有没有这个方法：如果没有就不能调用Swim2
        swim.swim();
        new Swim() {
            @Override
            public void swim() {
                System.out.println("在匿名内部类里面实现接口抽象方法");
            }
            public void swim2() {
                System.out.println("在匿名内部类里面新增自己的方法");
            }
        }.swim2();

        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("在匿名内部类里面实现父类的抽象方法");
            }
        };
        animal.eat();

        method(new Animal() {
            @Override
            void eat() {
                System.out.println("直接使用method方法，但是传进去的是一个匿名内部类的对象！");
            }
        });
    }
    public static void method(Animal a){
        a.eat();
    }
}

class Student implements Swim
/**********这一段相当于是一个没有名字的类************/
{
    @Override
    public void swim() {
        System.out.println("在有名字的类中实现接口中的抽象方法");
    }
}

/*******************************************/
interface Swim {
    void swim();
}

abstract class Animal {
    abstract void eat();
}