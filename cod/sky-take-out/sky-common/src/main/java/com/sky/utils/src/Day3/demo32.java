package Day3;

//在使用char，byte，short类型的变量中进行运算会把变量类型先转换为int类型（向上转型）：即使进行运算的是两个相同类型的变量
public class demo32 {
    public static void main(String[] args) {
        byte b1 = 1;
        byte b2 = 2;
        short s = 3;
        char c = 'S';

        //两个相同byte类型变量运算
        //如果这么写会报错的：byte b3=(b1+b2);
        int b3 = b1 + b2;
        //char，byte，short类型的变量的运算
        int sum = b1 + b2 + s + c;
    }
}
