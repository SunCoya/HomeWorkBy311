package Day15.demo151;
/*
抽象类
问题情景：假如学生，老师都继承于Person类，Person类中有方法叫work
对于学生和老师来说，工作的内容都不一样，所以需要重写方法work
如果有人故意不在学生类中重写（或者说是忘记了），程序就有可能出问题：
老师类和学生类调用work方法时依然是父类的方法，不是老师与学生类各自的方法
这里就引出了今天的：

抽象方法：
多个对象中把共性的内容抽取到父类之后，如果每一个子类的执行内容不一样，导致父类中无法确定具体方法，就可以把这个方法定义为抽象方法
对于父类中的抽象方法，子类必须重写（强制性的）
抽象类：
抽象方法所在的类就是抽象类！
如果一个类中有一个及以上抽象方法，那就必须定义为抽象类
抽象方法格式：
抽象方法不用写方法体{}，用分号；结束
public abstract 返回类型 方法名（......）；
抽象类格式：
public abstract class 类名{}
抽象方法优点：
适合多人开发，规定好方法名，返回类型，参数，以便让所有人写的方法都是一个样式的，可以规范写法，强制子类必须按照一种格式进行重写

注意事项：
1.抽象类不能够创建对象(重写里面的方法的话还是可以创建对象的)
2.有抽象方法就一定是抽象类,但是抽象类中不一定有抽象方法，这样的抽象类的作用就是不能创建抽象类的对象
3.抽象类中可以有构造方法———作用：给子类的属性进行赋值
4.抽象类的子类：要么这个子类重写抽象类中的所有抽象方法，要么这个子类也是一个抽象类，一般采取第一种办法

*/

public class Test {
    public static void main(String[] args) {
        //注意事项1：在这里不能够new Animal抽象类的对象
        System.out.println("子类对象调用其抽象父类的非抽象方法");
        new Frog().drink();
        System.out.println("子类对象调用其重写的其父类的抽象方法");
        new Dog().eat();
        System.out.println("用子类的构造方法（使用super调用抽象父类中的构造方法）创建子类对象，再调用其重写的其父类的抽象方法");
        new Sheep("羊羊",5).eat();
    }
}
abstract class Animal{
    private String name;
    private int age;
    public abstract void eat();
    public void drink(){
        System.out.println("小动物在喝水");
    }
    public Animal(){};
    //注意事项3：抽象类中也可以有构造方法
    public Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
class Dog extends Animal{
    public Dog(){}
    public Dog(String name,int age){
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println("小狗狗吃骨头");
    }
}
class Frog extends Animal{
    public Frog(){}
    public Frog(String name,int age){
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println("小青蛙吃虫子");
    }
}
class Sheep extends Animal{
    public Sheep(){}
    public Sheep(String name,int age){
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println("小山羊吃草");
    }
}
abstract class Cat extends Animal{
    //注意事项4：抽象类的子类抽象类：可以不用重写方法
}
