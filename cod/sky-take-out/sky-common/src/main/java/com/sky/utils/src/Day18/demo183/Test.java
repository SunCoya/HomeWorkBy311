package Day18.demo183;

import java.util.Arrays;
/*
1.什么是深度克隆？
2.深度克隆的两个字符串地址会相等吗
*/
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User(1,"zhangsan","123",new int[]{1,2,3,4,5});
        User user2 = (User) user1.clone();
        System.out.println("1.深度克隆为对象的属性值创建新引用数据类型对象，并添加到浅克隆的对象的属性中："+user1.getData()+user2.getData());
        System.out.println("2.深克隆：两个数组的地址不一样：但是这里的字符串还是一样的，存储在串池中："+(user1.getName()==user2.getName()));
    }
}
class User implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        int[] data = this.data;
        int[] newDate = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            newDate[i] = data[i];
        }
        User user = (User) super.clone();
        user.setData(newDate);
        return user;
    }
    private int id;
    private String name;
    private String passwd;
    private int[] data;
    public User() {
    }
    public User(int id, String name, String passwd, int[] data) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.data = data;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public int[] getData() {
        return data;
    }
    public void setData(int[] data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
