package Day10;

//常见的创建String对象的不同方式
public class demo101 {
    public static void main(String[] args) {
        //直接赋值
        String str1 = "gaga";

        //根据字符数组创建新的字符串对象
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        String str2 = new String(chars);
        System.out.println("输出由char类型的数组创建出来的字符串：" + str2);
        System.out.println("输出数组与字符串的拼接：" + chars);
        System.out.print("直接输出数组：");
        System.out.println(chars);//这个也是输出字符串

        //创建字节数组，根据字节数组的内容创建字符串：根据ascii表把数字换成字符串
        //网络中传递信息都是使用字节信息，需要把字节信息进行转换变成字符串，就需要用到这个构造。
        byte[] bytes = {97, 98, 99, 100, 101};
        String str3 = new String(bytes);
        System.out.println("输出由byte类型数组创建出来的字符串" + str3);
    }
}
