package Day8.pojo;

public class Phone2 {
    private double price;
    //private：用来修饰方法和变量：只能在  本类  中才能访问-----让该对象的数据更加安全
    public double getPrice() {
        return price;
    }
    public void setPrice(double price){
        if (price>=0){this.price = price;}
        else{System.out.println("输入错误"); }
    }
}