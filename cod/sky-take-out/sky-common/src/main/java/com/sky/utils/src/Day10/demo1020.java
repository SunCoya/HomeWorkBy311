package Day10;

import java.util.Random;

//练习：生成验证码，四位字母（不分大小写），一位数字（随机位置）
// 我的思路是先把数字放在char[]当中，再从零开始把字母一个一个加入到数组中，但是每加一个要判断一下
// 老师的思路是最后加入数字，再用随机数替换最后一个数字与前面的字母的位置就可以了
public class demo1020 {
    public static void main(String[] args) {
        char[] arr = new char[52];
        for (int i = 0; i < 26; i++) {
            arr[i]=(char)('a'+i);
        }
        for (int i = 0; i < 26; i++) {
            arr[i+26]=(char)('A'+i);
        }
        char[] verification =new char[5];
        Random random=new Random();
        for (int i = 0; i < 4; i++) {
            verification[i]=arr[random.nextInt(arr.length)];
        }
        verification[4]=(char)(random.nextInt(10)+'0');
        System.out.println(verification);

        int r=random.nextInt(4);
        char temp=verification[4];
        verification[4]=verification[r];
        verification[r]=temp;
        System.out.println(verification);
    }
}
