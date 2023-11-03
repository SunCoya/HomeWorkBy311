package Day18.demo184;
import com.google.gson.Gson;
//全部克隆方法：使用Gson的具体步骤
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User(1,"zhangsan","123",new int[]{1,2,3,4,5});
        System.out.println("1.在模块中新建lib导入对象拷贝文件gson.jar");
        System.out.println("2.创建Gson对象");
        Gson gson = new Gson();
        String s= gson.toJson(user1);
        System.out.println("3.利用gson把对象转换成字符串类型Json："+s);
        System.out.println("4.利用gson把Json转换成新User对象");
        User user2 = gson.fromJson(s,User.class);

        System.out.println("比较两个对象的属性地址："+(user1.getName()==user2.getName()));
    }
}
