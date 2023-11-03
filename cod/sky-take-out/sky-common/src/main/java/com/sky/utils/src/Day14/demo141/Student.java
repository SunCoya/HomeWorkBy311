package Day14.demo141;

public class Student extends Person{
    public Student(String name, int age) {
        super(name, age);
    }
    public Student() {}
    @Override
    public  void  show(){
        System.out.println("学生信息为："+name+" "+age);
    }

}
