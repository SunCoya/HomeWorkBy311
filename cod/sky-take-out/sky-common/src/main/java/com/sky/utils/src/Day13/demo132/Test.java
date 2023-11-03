package Day13.demo132;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        double[] arr2 = {1.1,2.2,3.3,4.4,5.5};
        System.out.println("使用工具类名直接调用静态方法：");
        System.out.println(ArrayUtil.printArr(arr1));
        System.out.println(ArrayUtil.getAverage(arr2));
    }
}
