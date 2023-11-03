package Day22;
/*
Collection：单列集合，一次只添加一个数据
单列集合里面又分为Set系列与List系列
List系列的主要特点就是添加的元素是：有序可重复
Set系列的主要特点就是添加的元素是：无序不可重复（类似于Python中的集合Set）
Collection是所有单列集合的父接口：常见共有方法：
增add  删clear remove  查contains isEmpty size
*/

import java.util.*;

public class Demo221 {
    public static void main(String[] args) {
        Collection<String> collection1 = new ArrayList<>();
        //对于list系列add方法一定返回true
        System.out.println(collection1.add("aaa"));
        collection1.add("bbb");
        collection1.add("ccc");
        System.out.println(collection1);


        //对于Set系列，如果重复了就返回false
        System.out.println();
        Collection<String> collection2 = new HashSet<>();
        System.out.println(collection2.add("aaa"));
        System.out.println(collection2.add("aaa"));
        System.out.println(collection2);
        collection2.remove("a");


        //对于共性remove方法，Set无序，只能通过元素对象进行删除,方法有返回
        System.out.println();
        collection1.remove("aaa");
        System.out.println(collection1);

        //判断是否有元素,右键方法goto选择implementation可以查看其在实现类中的实现
        //底层判断是否相等使用的是equals方法判断，如果自定义对象，想要比较对象值相等，就重写equals吧
        System.out.println(collection1.contains("bbb"));
        Collection<Student> collection3 = new ArrayList<>();
        Student s1 = new Student("爱丽丝", 16);
        Student s2 = new Student("爱丽丝", 16);
        collection3.add(s1);
        System.out.println(s2 == s1);
        System.out.println(collection3.contains(s2));

        //对于Set，只要对象地址不同，都可以加入
        Collection<Student> collection4 = new HashSet<>();
        collection4.add(s1);
        collection4.add(s2);
        System.out.println(collection4);

        //返回是否为空与元素数量
        System.out.println(collection4.isEmpty() +" "+ collection4.size());
    }
}

class Student {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        //这里调用的是String的属性的对比
        //如果是数组的话，就调用Arrays工具类去一个一个的比较数组内容，内容相等就返回对
        return age == student.age && Objects.equals(name, student.name);
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
