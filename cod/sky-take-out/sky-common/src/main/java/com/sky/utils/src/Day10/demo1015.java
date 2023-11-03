package Day10;

//字符串拼接原理
public class demo1015 {
    public static void main(String[] args) {
        //1.等号右边没有变量参与的情况
        //触发字符串优化机制，在编译过后就已经是最终的结果了，相当于String s=“abc”，故该语句在串池中创建一个有“abc”的内存空间
        String s = "a" + "b" + "c";

        //等号右边有变量参与的情况
        //在串池中开辟“a”的空间就
        String s1 = "a";
        //在堆内存中(不是串池)new一个StringBuilder对象，调用append方法合并a与b，再调用toString方法转变回字符串（字符串也在堆内存中），
        //相当于 String s2=new StringBuilder().append(s1).append("b").toString;
        //ctrl+N右上角选择allPlaces搜索StringBuilder对象，ctrl+F12搜索toString方法查看源码
        String s2 = s1 + "b";
        //在堆内存中new一个StringBuilder对象，内容为”abc“
        String s3 = s2 + "c";

        //在JDK8以前，这行代码要在内存中创建4个对象（ab与abc），在JDK8及以后，只要创建一个字符串对象个（abc）
        String s4 = s1 + s2 + s3;

        //结论：在字符串运算中使用+号拼接比较占内存（会创建新的对象）
    }
}
