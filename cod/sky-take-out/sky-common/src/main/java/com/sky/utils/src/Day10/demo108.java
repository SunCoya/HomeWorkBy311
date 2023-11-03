package Day10;

//把int类型的最高七位的 数据转化为中文收据形式（黑马学习版）
public class demo108 {
    public static void main(String[] args) {
        int money = 123456;
        String str = "";
        int number;
        //这里是把数据先全部提取出来，再处理数据格式
        while (money != 0) {
            number = money % 10;
            money /= 10;
            str = numberToChinese(number) + str;
        }
        while (str.length() != 7) {
            //补齐七位
            str = "零" + str;
        }
        //添加单位,这里使用数组更加方便，要学习这种把数据存储在数组中的思想，方便修改
        String[] arr = {"佰", "拾", "万", "仟", "佰", "拾", "元"};
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            answer += str.charAt(i);
            answer += arr[i];
        }
        System.out.println(answer);
    }

    public static String numberToChinese(int number) {
        //这里我原本用的switch,太过于繁杂
        String arr[] = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        return arr[number];
    }
}
