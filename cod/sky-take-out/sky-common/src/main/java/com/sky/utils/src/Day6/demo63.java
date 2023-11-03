package Day6;
//基本数据类型：如int,double,boolean,char
//引用数据类型：其他，如int[]，String，变量名存储的是存储数据的地址(引用地址)
//在方法中，基本数据类型的形参实参相互不影响，引用数据类型形参实参相互关联：因为用的是同一处地址
public class demo63 {
    public static void main(String[] args) {
        //方法调用时是存在栈内存中的，方法开始就是入栈，方法结束就出栈
        System.out.println("main方法入栈，a,b初始值皆为true");
        boolean a=true;
        System.out.println("基本数据类型a在调用change方法前："+a);
        change(a);
        System.out.println("基本数据类型a在调用change方法后："+a);

        boolean[] b={true};
        System.out.println("引用数据类型b在调用change方法前："+b[0]);
        change(b);
        System.out.println("引用数据类型b在调用change方法后："+b[0]);
        System.out.println("main方法出栈");
    }

    public  static void change(boolean a){
        System.out.println("change a 方法入栈");
        //这里的false赋值给了栈内存中change方法内的变量名a
        //不影响栈内存中main方法内的变量a
        a=false;
        System.out.println("基本数据类型a在change方法中时："+a);
        System.out.println("change a 方法出栈");
    }

    public static void change(boolean[] b){
        System.out.println("change b 方法入栈");
        b[0]=false;
        System.out.println("引用数据类型b在change方法中时："+b[0]);
        System.out.println("change b 方法出栈");
    }
}
