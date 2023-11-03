package Day14.demo144;

public class Person {
    private String name;
    private int age;
    public void keepPet(Animal animal, String something) {
        //饲养狗
        if (animal instanceof Dog dog) {
            System.out.println("年龄为" + age + "岁的" + name + "养了一只" + dog.getColor() + "的" + dog.getAge() + "岁的狗");
            dog.eat(something);
            //调用狗类的特有方法
            dog.lookHome();
            return;
        } else if (animal instanceof Cat cat) {//饲养猫
            System.out.println("年龄为" + age + "岁的" + name + "养了一只" + cat.getColor() + "的" + cat.getAge() + "岁的猫");
            cat.eat(something);
            cat.catchMouse();
        } else {
            System.out.println("暂时没有这种类型的动物");
        }
    }
    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
