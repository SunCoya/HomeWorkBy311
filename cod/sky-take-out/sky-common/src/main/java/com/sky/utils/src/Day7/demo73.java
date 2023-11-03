package Day7;
public class demo73 {
    public static void main(String[] args) {
        //二维数组静态初始化:大括号里面用大括号来代表分组
        int a[][] = new int[][]{
                {1, 2, 3},
                {1, 2},
                {1}
        };
        //简化书写格式
        int b[][] = {
                {1, 2, 3},
                {1, 2},
                {1}
        };
        System.out.println("输出a的地址："+a);
        //输出a[i]:输出第i个一维数组的地址值
        for (int i = 0; i < a.length; i++) {
            System.out.println("输出a["+i+"]的地址："+a[i]);
        }
        //遍历数组：数组的每行长度可以变化。
        System.out.println("遍历静态数组：");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}

