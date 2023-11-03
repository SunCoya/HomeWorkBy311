package Day10;

//StringBuilder简单练习：可以对比后面的StringJoiner的学习
public class demo1013 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]);
            sb.append(',');
        }
        sb.append(arr[arr.length - 1]);
        sb.append(']');
        System.out.println(sb);
    }
}
