package Day13.demo131;
//原本学生类的三个属性：姓名，年龄，性别
//这里加入新属性：老师的姓名
public class Student {
    private String name;
    private int age;
    private String gender;
    //老师的姓名,设置为public，可以直接使用对象.属性来引用
    public static String teacherName;
    public void study(){
        System.out.println(name + "正在学习");
    }
    public void show(){
        System.out.println(name+" "+ age+" "+gender+" "+teacherName);
    }
    public Student() {
    }
    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
