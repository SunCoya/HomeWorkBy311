package Day21;
//递归算法:核心思想就是大问题拆解成为小的问题:自己调用自己：案例1加到100
public class Demo215 {
    public static void main(String[] args) {
        System.out.println(method(100));
    }
    public static int method(int i){
        if (i>1) return i+method(i-1);
        return 1;
    }
}
