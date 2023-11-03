package Day14.demo141;
/*
    多态：面向对象三大特征之一：封装，继承已学。
    封装-继承-多态，这是按照顺序被开发的，先有前面的条件，再有后面的条件
    多态：对象的多种形态
    如Student类继承于Person类：可以有如下用法：
    Student s1 = new Student();
    Person s2 = new Student();
    应用场景：当学生，老师，管理者三者共同注册学生管理系统的时候，想要在一个方法里面执行
    就需要传入一个父亲类：代表三个儿子类：就是为了避免多种用户要去加同一个功能代码的方法
    多态的总结：儿子的对象赋值给父类类型的变量

    多态中的方法：如果子类中重写了父类的方法，父类被赋值了子类对象：父类的变量如果调用本类的方法：则会根据子类重写的方法调用子类的方法。

    多态实现前提：（一定要有继承或者实现关系）
    1.父类指向子类对象
    2.重写方法：如果不重写就会调用父类中的方法
*/
public class Test {
    public static void main(String[] args) {
        Student student=new Student("张三",23);
        Teacher teacher = new Teacher("王建国",45);
        Administrator administrator = new Administrator("Coya",20);
        register(student);
        register(teacher);
        register(administrator);
    }
    public  static void register(Person person){
        //如果看到一个方法中传递的参数是一个类：那么就可以传递所有这个类的子类对象：就像是有些方法里面传递Object一样：你可以传所有类进去
        person.show();
    }
}
