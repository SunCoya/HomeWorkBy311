package Day13.demo1311;

/*
    方法的重写：在子类中把父类的方法再写一遍，当父类方法不能够满足子类需求的时候，就需要进行方法的重写
    需要标注：@Override：重写注解，加上这个如果重写错误会标红，更加安全
    Student类中的虚方法表中，会对Person类中的虚方法表进行继承，如果写了重写方法，就会对虚方法表中原来的方法进行覆盖

    注意事项：
    重写方法时，重写方法的名称和形参列表必须与父类中的一样。
    子类方法访问权限子类必须大于等于父类（这个案例中你用private是不行的,子类必须比父类更加开放）
    子类方法返回值类型必须小于等于父类（如果父类中的方法返回类型是B类，子类中的方法返回类型是A类，【A是父类，B是子类，C是B的子类】
    会报错，子类中的方法返回类型必须是B类或者C类（子类必须比父类跟专精））
    比如在这个案例中，如果person类返回类型是son，student类返回类型是father，会报错，
 */
public class Test {
    public static void main(String[] args) {
        Student  s = new Student();
        s.eat();
    }
}
class Father{}
class Son extends Father {}
class Person {
    Father eat() {
        System.out.println("吃饭");
        return null;
    }
}
class Student extends Person{
    @Override
    Son eat(){
        super.eat();
        System.out.println("吃食堂");
        return null;
    }
}
