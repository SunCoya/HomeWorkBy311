package Day14.demo143;

/*多态的优势：
1.方法传参可以传递父类参数，便于接收所有的子类对象，方法返回值也能够返回父类，这样在方法内部也能够返回子类对象
2.在使用子类对象的方法的时候，可以用父类的对象变量去调用，这样，在修改代码的时候，只需要改变new出来的子类对象就可以咯
比如Person p = new Student  p.work()*/
/*
多态的弊端：不能够调用子类里面的特有方法
比如在这个案例中创建完dog对象后调用lookHome方法是不行的：
解决办法：把调用者A变回子类类型就可以了，也就是使用强制转换：如int转byte
需要注意的是：Animal变量赋值的是Dog的对象，所以在这里，不能转换为Cat
*/
public class Test {
    public static void main(String[] args) {
        Animal animal = new Dog();
        System.out.println(animal.name);
        animal.show();
        if (animal instanceof Dog) {//判断animal是不是Dog类型
            Dog dog = (Dog) animal;
            dog.lookHome();
        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.eatFish();
        } else {
            System.out.println("没有这个类型，无法转换");
        }
        //下面的是简写方法：节省代码，三行并一行
        if (animal instanceof Dog dog) dog.lookHome();
        else if (animal instanceof Cat cat) cat.eatFish();
        else System.out.println("没有这个类型，无法转换");
    }
}

class Animal {
    String name = "动物";
    public void show() {
        System.out.println("Animal的show方法");
    }
}

class Dog extends Animal {
    String name = "狗狗";
    @Override
    public void show() {
        System.out.println("修沟的show方法");
    }
    public void lookHome() {
        System.out.println("狗狗看家，这个方法如果使用多态不能被父类变量调用,需要再创建Dog类型变量调用方法！");
    }
}

class Cat extends Animal {
    String name = "猫猫";
    @Override
    public void show() { System.out.println("猫猫的show方法"); }
    public void eatFish() {
        System.out.println("猫猫吃鱼");
    }
}
