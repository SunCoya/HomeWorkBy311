package Day13.demo133;
//1.静态方法不能含（没有）this关键字
//2.非静态方法中可以访问所有变量及方法
//3.静态方法中只能访问静态变量及方法
public class Student {
    String name;
    int age;
    static String teacherName;
    //这个方法在平时是简写的
    //非静态方法和调用它的对象相关
    public void show(Student this){
        System.out.println("非静态方法能够访问方法调用者（this）的地址，也能访问非静态方法，非静态变量:\n"+this);
        System.out.println(this.name+" "+age+" "+teacherName);
        this.show1();
        System.out.println("非静态方法中也能够调用静态方法：下面是非静态方法中调用的静态方法");
        this.method();
    }
    public void show1(){
        System.out.println("show非静态方法");
    }
    public static void show2(){
        System.out.println("show静态方法");
    }
    public static void method(){
        //静态方法中不能访问非静态变量，这个方法中不能调用name，age（ 堆内存中的静态区里面不存这些）
        //也不能调用show方法与show1方法
        System.out.println("静态方法中只能访问静态变量及方法：\n"+teacherName);
        show2();
    }
}
