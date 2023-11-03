package Day6;
//Java中程序最小执行单元是方法
public class demo61 {
    public static void main(String[] args) {
        myMethod1();
        myMethod2(20,80);//实参--实际参数
        System.out.println("调用带返回值的方法："+myMethod3(20,80));
    }
    //1.简单的方法定义——方法名首字母小写更加规范
    public static void myMethod1(){
        System.out.println("调用简单方法");
        return;//这句话可以省略不写
    }
    //2.带参数的方法定义
    public static  void  myMethod2(int num1,int num2){//形参--形式参数
        System.out.println("调用带参数的方法："+(num1+num2));
    }
    //3.带返回值的方法的定义
    public  static  int  myMethod3(int num1,int num2){
        return num1+num2;
    }
}
