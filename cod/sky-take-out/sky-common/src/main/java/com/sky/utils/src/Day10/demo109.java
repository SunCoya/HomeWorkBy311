package Day10;

//subString用法：包头不包尾
//截取电话号码中间四位
public class demo109 {
    public static void main(String[] args) {
        String phoneNumber = "19567417827";
        String str = " **** ";
        phoneNumber = phoneNumber.substring(0, 3) + str + phoneNumber.substring(7);
        System.out.println(phoneNumber);
    }
}
