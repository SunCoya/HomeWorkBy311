package Day18.demo185;

import java.util.Objects;
/*
    Objects工具类:equals方法
需求背景：比较两个对象属性值是否相同：之前是在demo里面使用重写equals方法写的
问题：在这里如果s1为空，则不能创建对象，也就不能调用 equals方法。
*/
public class Test {
    public static void main(String[] args) {
        Student s1 = null;
        Student s2 = new Student("张三",23);
        Student s3 = new Student("张三",23);
        System.out.println("在这里我们使用Objects类中equals方法比较两个对象的属性值");
        System.out.println("Objects的equals方法方法底层会先看地址是否相等：如果不相等：就会判断s1是否为空：");
        System.out.println("如果不为空，就调用s1的equals方法：看你有没有重写equals方法");
        System.out.println("如果没重写依然比较地址是否相等，如果重写了那就调用你自己重写的方法");
        boolean result1 = Objects.equals(s1,s2);
        boolean result2 = Objects.equals(s2,s3);
        System.out.println(result1+" "+result2);
    }
}
class Student{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }
    private String name;
    private int age;
    public Student() {
    }
    public Student(String name, int age) {
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
    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
