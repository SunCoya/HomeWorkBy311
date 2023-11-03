package Day9.demo92;
import java.util.Scanner;
//定义数组存储两部汽车对象，属性为品牌创建两个汽车对象，把数据通过键盘录入到数组当中
public class CarTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Car[] cars=new Car[2];
        //在用数组声明对象的时候并没有在内存中创建多个对象，只是声明了要存储的对象类型与个数
        System.out.println(cars);
        System.out.println(cars[0]);
        for (int i = 0; i < cars.length; i++) {
            Car car=new Car();//车对象不能写在循环外边

            System.out.println("请输入价格：");
            int price=scanner.nextInt();
            car.setPrice(price);
            System.out.println("请输入品牌：");
            String brand=scanner.next();
            car.setBrand(brand);
            System.out.println("请输入颜色：");
            String color=scanner.next();
            car.setColor(color);

            cars[i]=car;
        }
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
    }
}
