package Day8;
//封装：面向对象的三大特征之一（其他两个是继承和多态）
//封装的意思是要正确地设计对象的属性和方法：
//封装原则：对象代表什么，就得封装对应的数据，并提供数据对应的行为
import Day8.pojo.Phone2;
//在Phone2中封装好数据，在setter方法中对数据进行范围限制，可以简化测试代码。
public class demo82 {
    public static void main(String[] args) {
        Phone2 phone=new Phone2();
        phone.setPrice(-10000);
        System.out.println(phone.getPrice());
        phone.setPrice(10000);
        System.out.println(phone.getPrice());
    }
}
