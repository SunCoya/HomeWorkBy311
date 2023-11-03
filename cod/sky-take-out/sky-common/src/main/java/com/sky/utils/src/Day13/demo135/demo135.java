package Day13.demo135;

/*
面向对象三大特征之二：封装，继承
继承：为了解决对象太多，对象繁杂，且不同对象中重复属性多的问题
优点：可以提高代码复用性，子类也可以在父类基础上添加更多功能，使子类更加强大
继承特点：只能支持单继承，不能支持多继承，支持多层继承，每一个类直接或者间接继承Object
需要注意的一点，如果在父类中修饰方法使用private（只能在本类中才能用）,子类中的方法就无法使用父类中的方法
也就是说————子类只能访问父类中非私有的成员方法
*/
public class demo135 {
    public static void main(String[] args) {
        RagDoll rd = new RagDoll();
        rd.eat();
        rd.catchMouse();
        Husky h = new Husky();
        h.drink();
        h.LookHouse();
        h.breakHouse();
    }
}
class Animal {
    public void eat(){
        System.out.println("小动物在吃吃");
    }
    public void drink(){
        System.out.println("小动物在喝水");
    }
}
class Cat extends Animal{
    public void catchMouse(){
        System.out.println("猫猫抓老鼠");
    }
}
class LiHua extends Cat{}
class RagDoll extends Cat{}
class Dog extends Animal{
    public void LookHouse(){
        System.out.println("修勾勾在看家");
    }
}
class Husky extends Dog{
    public void breakHouse(){
        System.out.println("哈士奇在拆家");
    }
}
class Teddy extends Dog{
    public void touch(){
        System.out.println("泰迪摸摸");
    }
}
