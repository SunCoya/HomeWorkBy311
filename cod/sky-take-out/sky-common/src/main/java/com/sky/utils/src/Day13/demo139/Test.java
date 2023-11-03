package Day13.demo139;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println("在继承中，成员变量的访问特点：就近原则，优先使用子类中的内容");
        System.out.println(son.name);
    }
}
class Father {
    String name = "父亲";
}
class Son extends Father {
    String name;
}
