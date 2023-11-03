package Day20;

//包装类:便于传进函数内（Object参数）
//包装类中传入127与传入128，在底层是如何创建对象的？
public class Demo2010 {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println("传入127只创建一个对象，传入128创建的是不同对象");
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }
}
