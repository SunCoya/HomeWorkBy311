package Day10;

//替换字符串：replace方法：
public class demo1010 {
    public static void main(String[] args) {
        String talk = "你TMD,CNM,TNND,MLGB";
        String[] arr = {"TMD", "NMD", "CNM", "TNND", "MLGB", "SB"};
        for (int i = 0; i < arr.length; i++) {
            talk = talk.replace(arr[i], "***");
        }
        System.out.println("把所有敏感词都替换掉后的内容为\n"+talk);
    }
}
