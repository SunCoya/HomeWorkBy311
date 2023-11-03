package Day10;

//StringBuilder的底层原理：默认容量为16，内部存放ASCII码，最大长度是Int的最大值
//超过这个容量时，会扩容：老容量*2+2=34。超过34后则以实际字符串长度为准
public class demo1016 {
    public static void main(String[] args) {
        System.out.println("创建StringBuilder");
        StringBuilder sb = new StringBuilder();
        System.out.println("输出初始状态下StringBuilder的容量:"+sb.capacity());
        System.out.println("输出初始状态下StringBuilder的长度:"+sb.length());
        sb.append("abc");
        System.out.println("输出加入长度为3的字符串后StringBuilder的容量:"+sb.capacity());
        System.out.println("输出加入长度为3的字符串后StringBuilder的长度:"+sb.length());//输出StringBuilder的长度
        sb.append("defghijkmnlopqrstuvwxyz");
        System.out.println("输出再次加入长度为23的字符串后（此时StringBuilder长度为26,超过16）StringBuilder的容量:"+sb.capacity());
        System.out.println("输出再次加入长度为23的字符串后（此时StringBuilder长度为26，超过16）StringBuilder的长度:"+sb.length());
        sb.append("0123456789");
        System.out.println("输出再次加入长度为10的字符串后（此时StringBuilder长度为36，超过34）StringBuilder的容量:"+sb.capacity());
        System.out.println("输出再次加入长度为10的字符串后（此时StringBuilder长度为36，超过34）StringBuilder的长度:"+sb.length());

        System.out.println("创建第二个StringBuilder");
        StringBuilder sb1 = new StringBuilder();
        sb1.append("abcdefghijkmnlopqrstuvwxyz0123456789");
        System.out.println("输出直接加入长度为36的字符串后（此时StringBuilder长度为36，超过34）StringBuilder的容量:"+sb1.capacity());//输出StringBuilder的容量
        System.out.println("输出直接加入长度为36的字符串后（此时StringBuilder长度为36，超过34）StringBuilder的长度:"+sb1.length());//输出StringBuilder的长度
        sb1.append("abcdefghijkmnlopqrstuvwxyz0123456789");
        System.out.println("输出再次加入长度为36的字符串后（此时StringBuilder长度为72，超过36）StringBuilder的容量:"+sb1.capacity());//输出StringBuilder的容量
        System.out.println("输出再次加入长度为36的字符串后（此时StringBuilder长度为72，超过36）StringBuilder的长度:"+sb1.length());//输出StringBuilder的长度
    }
}
