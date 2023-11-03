package Day7;

public class demo75 {
    public static void main(String[] args) {
        //二维数组特殊情况
        int[][] a=new int[2][];
        System.out.println("输出a的地址："+a);
        System.out.println("输出a[0]的地址："+a[0]);
        int [] b= {1,2,3,4,5};
        int [] c= {1,2,3};
        //地址赋值
        a[0]=b;
        a[1]=c;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
