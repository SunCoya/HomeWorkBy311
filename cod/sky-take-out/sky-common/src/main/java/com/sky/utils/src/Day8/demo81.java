package Day8;
import Day8.pojo.Phone1;
//在idea上方的类标签栏可以点右键选择分离界面，从而能够在页面上显示两个的代码
//编写main方法的类叫做测试类
public class demo81 {
    public static void main(String[] args) {
        Phone1 phone =new Phone1();
        phone.brand="小米";
        phone.price=1999;
        phone.call();
        phone.playGame();
        Phone1.staticMethod();
    }
}
