package Day13.demo1313;
//this:一个局部变量，当前方法调用者的地址
//super:代表父类存储空间
public class Test {
    public static void main(String[] args) {
        System.out.println("在子类的无参构造里面调用子类的有参构造：一般在给对象设置默认属性的时候使用");
        Son son = new Son();
        System.out.println(son.age);
    }
}
class Father {
    String name;
    int age;
    public Father(){
        System.out.println("先执行父类的无参构造");
    };
    public Father(String name,int age){
        this.name=name;
        this.age=age;
        System.out.println("先执行父类的有参构造");
    }
}
class Son extends Father {
    public Son() {
        //调用本类的其他构造方法，这里虚拟机就不会自动添加super()
        this(null,20);
    }
    public Son(String name, int age) {
        super(name, age);
        System.out.println("后执行子类的有参构造");
    }
}
