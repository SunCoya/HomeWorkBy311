package Day10;

//定义方法，把int数组中的数据按照指定格式拼接成字符串返回
//这里我感到疑惑的是，String是定长，如何一个个把数组中的数据加入到String中呢？
//这里使用的是字符串拼接--在串池中表现为创建新的字符串
public class demo105 {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(arrayToString(x));
    }
    public static String arrayToString(int[] x) {
        if (x.length == 0) {
            return "[]";
        } else {
            String str = "[";
            for (int i = 0; i < x.length - 1; i++) {
                str += x[i];
                str += ", ";
            }
            str += x[x.length - 1];
            str += "]";
            return str;
        }
    }
}
