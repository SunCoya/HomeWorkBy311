package Day13.demo133;

public class Test {
    public static void main(String[] args) {
        Student.teacherName="阿玮老师";
        Student s=new Student();
        s.name="zhangsan";
        s.age=23;
        System.out.println("s1的地址："+s);
        s.show();
    }
}
