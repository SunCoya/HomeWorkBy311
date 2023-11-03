package Day13.demo1312;
//继承中构造方法的访问特点：
/*
   1.父类中的构造方法不会被子类继承
   2.子类中的构造方法默认先访问父类中的无参构造，再访问自己：子类在初始化的时候有可能会使用到父类中的数据，父类没有初始化子类就用不了
   所以，子类的无参的构造方法中第一句默认是super(),不写也存在！
   想要调用父类的有参构造，就必须手动写super进行调用
*/
public class Test {
    public static void main(String[] args) {
        Son son1 = new Son();
        Son son2 = new Son("张三",23);
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
        System.out.println("后执行子类的无参构造");
    }
    public Son(String name, int age) {
        super(name, age);
        System.out.println("后执行子类的有参构造");
    }
}

