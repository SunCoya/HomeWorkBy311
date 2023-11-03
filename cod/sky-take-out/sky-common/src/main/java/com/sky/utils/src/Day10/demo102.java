package Day10;

//字符串在内存中的存储：
//直接赋值的字符串存储在串池中：String Table——JDK7之后，串池就放在了堆内存中。
//只要是直接赋值的字符串：如果说已经创建了一个相同的字符串，就不会再去创建新的字符串了！
public class demo102 {
    public static void main(String[] args) {
        //以下两个变量是同一个地址
        String str1 = "abc";
        String str2 = "abc";
        System.out.println("直接赋值的字符串如果数据相同，则地址也相同：" + (str1 == str2));//==号比较的是地址
        String str3 = "abcd";
        String str4 = new String("abcd");//new 出来的字符串对象不会存储在串池中
        System.out.println("字符串中，new出来的数据地址与直接赋值的数据如果一样，地址不会相同：" + (str3 == str4));
    }
}
