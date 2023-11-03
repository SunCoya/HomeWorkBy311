package Day13.demo1310;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println("在成员方法中使用不同关键字访问父亲，儿子中的成员变量");
        son.showName();
    }
}
class Grandpa {
    String name = "爷爷";
}
class Father extends Grandpa{
    String name = "父亲";
}
class Son extends Father{
    String name = "儿子";
    void showName(){
        String name ="儿子类中方法的局部变量";
        System.out.println("使用super访问父亲类中的变量：（在子类中最多调用一个super）"+super.name);
        System.out.println("使用this访问当前类的变量："+this.name);
        System.out.println("直接使用就近访问当前方法中的局部变量："+name);
    }
}

