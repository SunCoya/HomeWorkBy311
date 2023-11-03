package Day14.demo149;
//代码块：局部代码块，构造代码块，静态代码块
/*
局部代码块可以提前结束变量生命周期
构造代码块：写在成员位置的代码块,可以把多个构造方法中重复的代码写到构造方法块当中
静态代码块：构造代码块与静态代码块的区别：构造代码块可执行多次（随对象加载），静态代码块执行一次（随着类加载，一般用于数据初始化）
*/
public class Test {
    public static void main(String[] args) {
        {
            int a;
        }
        System.out.println("只有在局部代码块里面才能使用变量a,当代码执行到这里时，a就从内存中消失了");
        new Student();
        new Student("小红", 23);
    }
}
class Student {
    private String name;
    private int age;
    {
        System.out.println("在JavaBean类中的构造代码块内容");
    }
    static {
        //应用见Day12中的案例
        System.out.println("静态代码块内容");
        System.out.println();
    }
    public Student() {
        System.out.println("开始执行空参构造");
    }
    public Student(String name, int age) {
        System.out.println("开始执行全参构造");
        this.age = age;
        this.name = name;
    }
}
