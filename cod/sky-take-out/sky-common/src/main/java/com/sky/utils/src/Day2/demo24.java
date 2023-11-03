package Day2;

//将十进制转化为2-9进制
public class demo24 {
    public static void main(String[] args) {
        System.out.println(Solution(1820, 8));
        System.out.println(Solution(31, 16));//十六进制是不行的
    }

    //n是十进制数字，m是进制数，注意2<=m<=9
    public static StringBuilder Solution(int n, int m) {
        StringBuilder ans = new StringBuilder();
        //在这个过程中，我们需要一步一步得出来加入到我们最终结果的是余数还是商呢？是“余数”！商是用来确定前面的数字的！
        //这里肯定是要用到循环的，什么时候停下来呢？当我们的商小于m，也就是小于进制数不用再进位的时候！
        int a = n / m;//商
        int b = n % m;//余数
        ans.append(b);//把余数加入到新建立的字符串中
        while (a >= m) {
            b = a % m;//更新b!
            a = a / m;//接下来要被除的数是a了,这里顺序不要反了，一定要先改变余数再变商
            ans.append(b);
        }
        ans.append(a).reverse();
        return ans;
    }
}
