package Day10;

//把int类型的最高七位的 数据转化为中文收据形式(自己写的傻瓜版)
public class demo107 {
    public static void main(String[] args) {
        int money = 1234567;
        String str = "";
        int number = money % 10;
        money /= 10;
        str = numberToChinese(number) + "元" + str;
        number = money % 10;
        money /= 10;
        str = numberToChinese(number) + "拾" + str;
        number = money % 10;
        money /= 10;
        str = numberToChinese(number) + "百" + str;
        number = money % 10;
        money /= 10;
        str = numberToChinese(number) + "仟" + str;
        number = money % 10;
        money /= 10;
        str = numberToChinese(number) + "万" + str;
        number = money % 10;
        money /= 10;
        str = numberToChinese(number) + "拾" + str;
        number = money % 10;
        money /= 10;
        str = numberToChinese(number) + "佰" + str;
        System.out.println(str);
    }

    public static String numberToChinese(int number) {
        String str =switch (number) {
            case 0 ->"零";
            case 1 ->"壹";
            case 2 ->"贰";
            case 3 ->"叁";
            case 4 ->"肆";
            case 5 ->"伍";
            case 6 ->"陆";
            case 7 ->"柒";
            case 8 ->"捌";
            case 9 ->"玖";
            default->str=" ";
        };
        return str;
    }
}
