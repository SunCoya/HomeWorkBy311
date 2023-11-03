package Day7;

//将输入的正整数放到适当长度的数组当中
public class demo72 {
    public static void main(String[] args) {
        int num = 10086;
        int[] arr = getArr(num);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
    private static int[] getArr(int num) {
        int a = num;
        int count = 0;
        //得到整数位数
        while (a != 0) {
            a /= 10;
            count++;
        }
        //得到数组
        int[] arr = new int[count];
        a = num;
        for (int i = 0; i < count; i++) {
            arr[count - i - 1] = a % 10;
            a /= 10;
        }
        return arr;
    }
}