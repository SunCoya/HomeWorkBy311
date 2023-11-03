package Day21;
/*
lambda表达式省略规则
能够从原来接口中推导出来的就可以省略
只有一条语句的时候可以不写分号与大括号
方法只有一个参数则可省略大括号
参数类型与返回值也可以不写
*/
public class Demo2110 {
    public static void main(String[] args) {
        method(() ->System.out.println("重写的游泳方法"),
                a->a+666,
                (a,b)-> a+b);
    }
    public static void method(Swim swim,Swim2 swim2,Swim3 swim3) {
        swim.swimming();
        System.out.println(swim2.swimming("嘎嘎"));
        System.out.println(swim3.swimming("机械","，嘎嘎"));
    }
}
@FunctionalInterface
interface Swim {
    void swimming();
    boolean equals(Object o);
    default void swimming2(){
    }
    /*
        由于默认方法已经有了实现，所以它们不是抽象方法。
        如果一个接口中声明的抽象方法是重写了Object类中任意一个public方法
        那么这些抽象方法并不会算入接口的抽象方法数量中
        因为任何接口的实现类都会从其父类Object或其它地方获得这些方法的实现。
    */
}
@FunctionalInterface
interface Swim2 {
    String swimming(String a);
}
@FunctionalInterface
interface Swim3 {
    String swimming(String a,String b);
}

