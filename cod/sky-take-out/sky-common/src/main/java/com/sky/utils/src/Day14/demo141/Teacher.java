package Day14.demo141;

public class Teacher extends Person{
    public Teacher(String name, int age) {
        super(name, age);
    }
    public Teacher() {}
    @Override
    public  void  show(){
        System.out.println("老师信息为："+name+" "+age);
    }
}
