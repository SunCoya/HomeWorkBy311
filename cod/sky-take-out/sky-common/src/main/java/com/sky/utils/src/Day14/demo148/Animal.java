package Day14.demo148;

public abstract class Animal {
    protected void eat(){
        System.out.println("protect修饰的方法能够被其他包中的子类中调用，注意是子类“中”，不同包的其他类（如Test是不能够调用的）");
    }
}
