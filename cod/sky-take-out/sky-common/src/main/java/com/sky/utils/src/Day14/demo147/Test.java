package Day14.demo147;

import Day14.demo148.Animal;

//本包与demo148包联合实验：权限修饰符
/*
权限修饰符的分类：权限从小到大依次是private,default(无修饰符),protected,public
private只能在同一个类中使用，无修饰符时在同一个包中能使用。protected在不同包中的子类能够使用。public都能够使用
主要是关于protected有点不好理解：

实际开发中一般只是用private变量与public方法
在多处方法中使用了同一个方法，一般private使用的那个方法
*/
public class Test {
    public static void main(String[] args) {
        new Cat();
    }
}
class Cat extends Animal {
    public Cat() {
        super.eat();
    }
}

