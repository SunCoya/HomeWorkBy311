package Day3;

//赋值运算符的使用细节：在使用+=,-=,/=,*=,%=时
//左边变量的变量类型不会变。
//所以，如a+=b并不等同于a=a+b（a与b的变量类型不同的情况下）
public class demo34 {
    public static void main(String[] args) {
        int a = 1;
        byte b = 2;
        short s = 3;
        char c = 'A';

        a += 1.5;//相当于:a=(int)(a+1.5);
        //下个语句如果这么写是会报错的：b=b+1;
        b += 1;//相当于:b=(byte)(b+1);
        s += 1;//相当于:s=(short)(s+1);
        c += 1;//相当于:c=(char)(c+1);
        System.out.println("使用赋值运算符后的输出：");
        System.out.println(a + " " + b + " " + s + " " + c);

        a = (int) (a + 1.5);
        b = (byte) (b + 1);
        s = (short) (s + 1);
        c = (char) (c + 1);
        System.out.println("使用强制转换后的输出：");
        System.out.println(a + " " + b + " " + s + " " + c);
    }
}
