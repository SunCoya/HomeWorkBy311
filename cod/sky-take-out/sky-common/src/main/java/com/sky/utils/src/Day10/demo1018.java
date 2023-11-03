package Day10;
//把一个字符串的第一位移动到最后一位，看看这个重复过程能不能与另一个字符串的值相等
//StringBuffer版,复杂了
public class demo1018 {
    public static void main(String[] args) {
        String A="abcde";
        String B="eabcd";
        StringBuilder sbA=new StringBuilder(A);
        if (A.length()==B.length()) {
            for (int i = 0; i < A.length(); i++) {
                sbA=change(sbA);
                if (sbA.toString().equals(B)){
                    System.out.println("可");
                    return;
                }
            }
        }
        System.out.println("否");
    }
    public static StringBuilder change(StringBuilder sb1){
        StringBuilder sb2=new StringBuilder();
        //这里可以用到subString方法，不用一个一个去加
        sb2.append(sb1.substring(1));
        sb2.append(sb1.charAt(0));
        return sb2;
    }
}
