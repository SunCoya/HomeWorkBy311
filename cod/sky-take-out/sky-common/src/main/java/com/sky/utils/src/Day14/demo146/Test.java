package Day14.demo146;

/*
final修饰符：修饰方法、变量、类
1.修饰类时：该方法不能够被继承,也就是说不能够为父类！
2.修饰方法时：该方法不能够被重写@override！（在继承的情况下）
3.修饰变量时：该变量即为常量：一旦被赋值就不能够被改变了

1.如果是基本数据类型，则存储的数据值不会改变
2.如果是引用数据类型，情况就不一样了：变量存储的地址不会变！
也就是说，只是对象地址不变，对象的值还是能够变化，对于数组，也能改变数组内部的值
3.在字符串中，存储值的数组使用private final修饰的，也就是说String类型的变量一旦定义就不会被改变（不管有没有final）

常量命名规范：单个单词全部大写，多个单词也是全部大写，中间使用下划线隔开，在实际开发中，常量一般用于系统配置信息，方便维护,详情请见之前写的学生管理系统
*/

class Father {
    int age;
    String name;
    public Father() {}
    public Father(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public final void show() {
        //用final修饰的父类方法不能够被子类重写,不想让别人改编你的方法就用final来修饰.
    }
}
final class Son extends Father{
    //用final修饰的类无法拥有子类！
    public void show2(){
    }
}
public class Test {
    public static void main(String[] args) {
        final int a = 10;
        System.out.println("1.用final修饰的变量a只能被赋值一次:" + a);

        //常量命名案例
        final double PI = 3.14159265358979;
        final int MY_BIRTH = 628;

        System.out.println("对象内部的值是可以改变的，但是不能新建对象再赋给father变量了");
        final Father father = new Father(45, "父亲");
        father.age = 46;
    }
}

