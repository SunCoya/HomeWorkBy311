package Day10;

//StringBuilder的使用：可以看成是一个容器，创建之后里面的内容可变，不会像String那样产生新的对象
//用于大量修改String长度与字符串反转的时候
public class demo1011 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");//这里面也可以不放字符串

        System.out.println("使用length方法得到StringBuilder长度："+sb.length());

        sb.reverse();
        System.out.println("使用reverse方法反转StringBuilder："+sb);//直接输出和String一样会输出属性值！

        sb.reverse();
        //下列数据类型都可以加
        sb.append("d").append('e').append(12345.666);
        System.out.println("使用append方法添加字符或者字符串："+sb);

        String s = sb.toString();
        System.out.println("使用toString方法将StringBuilder转变为String："+s);
    }
}
