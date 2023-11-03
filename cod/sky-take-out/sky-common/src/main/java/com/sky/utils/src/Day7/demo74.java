package Day7;

public class demo74 {
    public static void main(String[] args) {
        //二维数组动态初始化
        int c[][] = new int[3][6];
        System.out.println("遍历动态数组：");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j]+"\t");
            }
            System.out.println();
        }
    }
}

