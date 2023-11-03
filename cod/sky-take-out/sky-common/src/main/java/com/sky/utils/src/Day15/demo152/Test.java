package Day15.demo152;
/*
接口
问题情景：
假设有三个类继承于Animal
狗，兔兔，青蛙：
对于吃饭和喝水的方法：三者都可以有
对于游泳的方法：兔兔不能有，青蛙和狗狗（多个类）可以有
但是这样就不能够在父类中使用abstract限定他们的方法了，只能分开来写，这样就有可能造成方法的不统一（如方法的名字）
这个时候就可以定义一个接口，接口里面定义游泳的abstract方法，
这样就可以创造一个规则，可以让青蛙类和狗狗类按照此规则书写代码。

定义接口格式（注意接口和类不一样，接口不能够写在类里面！）：
public interface 接口名{}
接口由类实现，通过implement表示

接口注意事项
1.接口不能创建对象（和抽象类一样）
2.implement某个接口的类一般称为实现类，在实现类要么实现所有的抽象方法（多数情况），要么是抽象类（少数情况）
3.一个类可以实现多个接口，也就是说会有多种规则（下面的案例中只实现了最多一个），这和继承就不一样了，一个子类只能继承于一个父类
4.实现类在继承一个类的同时也能够实现接口
5.接口和类不一样，接口里面的方法默认使用public abstract修饰：可以不写，接口方法不能用protected修饰！
在写好类名，继承与接口的时候可以点点IDEA的红色波浪线：会帮你自动生成方法的
*/
public class Test {
    public static void main(String[] args) {
        //注意事项1：在这下面不能够new Swim();
        System.out.println("调用对象实现的接口方法");
        new Dog().swim();
    }
}
abstract class Animal{
    private String name;
    private int age;
    public Animal(){};
    public Animal(String name, int age){
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
    public abstract void eat();
}
//接口名记得大写
interface Swim{
    //注意事项5：接口里面的方法默认使用public abstract修饰：可以不写
    public abstract void swim();
}
//注意事项4：实现类在继承一个类的同时也能够实现接口
class Dog extends Animal implements Swim{
    public Dog() {
    }
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println("吃骨头");
    }
    @Override
    public void swim(){
        System.out.println("狗刨");
    }
}
class Rabbit extends Animal{
    public Rabbit() {
    }
    public Rabbit(String name, int age) {
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println("吃胡萝卜");
    }
}
abstract class Car extends Animal implements Swim{
    //注意事项2：在实现类也可以是抽象类，可以不用实现抽象方法
}
