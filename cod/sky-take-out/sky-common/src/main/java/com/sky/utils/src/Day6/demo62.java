package Day6;
//方法的重载：
//在一个类的多个方法中可以用同一个名字作为方法名
//如：求不同个数的int类型变量的和（参数个数不同）
//再如：求不同类型变量（如double与int）的和（参数类型不同），都能用sum来命名方法。
//简单来说，就是一个类中的同名方法的形参（也就是方法定义中圆括号里面的定义形的形参）必须不一样(类型，个数，先后顺序)
//需要注意的是，方法的重载与返回类型无关，也就是说，如果方法名与形参都一样，只是返回类型不一样（如一个是int一个是byte），不构成重载关系，在IDEA中会报错。
//程序在调用方法时会根据传过去的参数判断应该使用哪一个方法。
public class demo62 {
    public static void main(String[] args) { int sum = sum(1, 0); }
    //以下方法构成重载关系
    public static int sum(int a, int b) {
        return a + b;
    }
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }
    public static double sum(double a, double b) {
        return (a + b);
    }
    public static double sum(int a, double b) {
        return (a + b);
    }
    public static double sum(double a, int b) {
        return (a + b);//这个和上面的一个虽然可以重载，但是没什么用处
    }
}
