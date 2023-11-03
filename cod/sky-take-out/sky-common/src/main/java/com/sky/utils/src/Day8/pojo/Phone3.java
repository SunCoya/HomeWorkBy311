package Day8.pojo;
//就近原则：方法中的变量会优先使用局部变量来表示。
//this作用：this.属性 能够引用该对象中的成员变量,在这里可以区分成员变量与局部变量
public class Phone3 {
    private String brand;
    public void setBrand1(String brand) {
        //这句话相当于把形参赋值给形参
        //在此方法中，方法外brand是类的成员变量，此方法内的是局部变量
        brand = brand;
    }
    public void setBrand2(String brand1) {
        //这里相当于定义了一个局部变量，把brand赋值给了局部变量，在这个类中定义的成员变量并没有被赋值
        String brand = brand1;
    }
    public void setBrand3(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
    public String getBrand1(){
        String brand="局部变量";
        return brand;
    }
    public String getBrand2(){
        String brand="局部变量";
        return this.brand;
    }
}