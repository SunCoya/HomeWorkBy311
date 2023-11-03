package Day18.demo181;

import java.util.Objects;

/*
Object类:
1.System.out.println调用对象默认输出什么？
2.在JavaBean类中重写Object类中的toString方法有什么用？
3.在JavaBean类中重写Object类中的equals方法方法有什么用？
4.重写equals方法的步骤？
*/
public class Test {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println("1.System.out.println：默认调用对象的toString方法"+obj.toString());

        Student stu1 = new Student("张三");
        System.out.println("2.在JavaBean类中重写toString方法，使得输出变为属性值"+stu1);

        Student stu2 = new Student("张三");
        System.out.println("3.equals方法原本是比较地址值：这里重写equals方法比较属性值（IDEA自带）");
        System.out.println("重写equals方法比较属性值相同的不同对象是否相等："+stu1.equals(stu2));
        System.out.println("4.重写步骤：先比较地址值是否一样，再判断非空与是否是同一个类，最后把传入的对象转换成Student类型比较属性值是否相等");
    }
}
class Student{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }
    @Override
    public String toString() {
        return "Student{" + "name='" + name +  '}';
    }
    private String name;
    public Student(String name) {
        this.name = name;
    }
    public Student() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
