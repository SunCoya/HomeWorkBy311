package Day13.demo131;
//static表示静态，是java中的一个修饰符，可以修饰成员变量，成员方法
//在这个案例中，我们在JavaBean中用static修饰成员变量
public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("张三",23,"男");
        Student student2 = new Student("李四",24,"男");
        //针对于一个班的同学而言：每个同学的老师都是同一个老师
        //这就是不合理的地方：设置了一个同学的老师，另一个同学的老师也应该被设置
        System.out.println("把Student类中的teacherName属性设置为static，把所有该类的对象的老师属性值共享");
        student1.teacherName = "阿玮老师";
        student1.show();
        student2.show();
        System.out.println("如果在JavaBean中设置属性为static：那么就能多出一种调用方式：直接使用类名调用（更加推荐这种方式）：");
        Student.teacherName="阿玮老师2";
        student1.show();
        student2.show();
        /*
        static在内存中的原理：
        把Student类的字节码文件加载到方法区
        在内存当中创建了一个单独存放静态变量的空间（这个空间叫做静态区JDK8以后静态区在堆空间里面）
        静态区里面存储着Student类里面所有的静态变量。
        静态变量随着类加载：优先于对象出现

        在上述demo131中：如果先执行的是这一行代码：
        Student.teacherName="阿玮老师2";
        在执行代码后，内存中不会出现Student对象。只是加载了Student类的class文件与存储了静态区中的static变量

        如果先执行的是这一行代码：
        Student student1 = new Student("张三",23,"男");
        内存中会出现student对象；但是过程是先加载Student类的class文件，再存储静态区中的static变量
        最后在堆内存中开辟对象空间（里面存储了所有非静态的成员变量）
        如果说student1想要找teacherName属性--就需要在静态区里面去寻找了
        结论：以后需要把所有一个类的对象的某个属性都设置为相同值的时候：把该属性用static修饰
        */
    }
}
