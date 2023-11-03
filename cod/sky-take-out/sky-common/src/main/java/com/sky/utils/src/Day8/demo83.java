package Day8;
import Day8.pojo.Phone3;
public class demo83 {
    public static void main(String[] args) {
        Phone3 phone=new Phone3();
        phone.setBrand1("小米");
        System.out.println("1. 在set方法中把形参赋值给形参（与该对象中成员变量同名）："+phone.getBrand());
        phone.setBrand2("小米");
        System.out.println("2.在set方法中把形参赋值给新定义的局部变量（与该对象中成员变量同名）："+phone.getBrand());
        phone.setBrand3("小米");
        System.out.println("3.在set方法中使用this.brand把变量指向该对象的成员变量："+phone.getBrand());
        System.out.println("4.在get方法中定义新的局部变量（与该对象中成员变量同名）并返回："+phone.getBrand1());
        System.out.println("5.在get方法中定义新的局部变量并使用this.brand把变量指向该对象的成员变量："+phone.getBrand2());
    }
}
