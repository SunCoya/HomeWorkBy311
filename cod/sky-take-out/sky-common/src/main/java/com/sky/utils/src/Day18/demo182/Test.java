package Day18.demo182;

import java.util.Arrays;

/*
Object类中的克隆方法：在克隆对象时，不复制地址，而是创建新对象复制属性值，方法在底层会创建一个新对象(Object类型)，并且把原对象的数据拷贝过去
1.Java中克隆方法能够在测试类中使用吗？为什么？
2.在克隆时如果属性值是引用数据类型，克隆的是对象还是地址值呢？
3.什么是浅克隆？
4.实现Cloneable接口有什么用？
*/
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("1.在Java中clone是用protected修饰的，在别的包中无法直接调用，只能在子类中重写");
        User user1 = new User(1,"zhangsan","123",new int[]{1,2,3,4,5});
        System.out.println("2.在拷贝的新对象中：会把全部数据值拷贝过来：如果是引用数据类型则会拷贝引用数据类型的地址值：也就是说两个对象的成员变量使用的是同一个地址值");
        User user2 = (User) user1.clone();
        System.out.println("3.浅克隆：克隆的属性是引用数据类型的地址："+user1.getData()+user2.getData());
        System.out.println("4.用户实现一个克隆接口，这个接口里面没有方法：用来标记的");
    }
}
class User implements Cloneable{
    //输入clone自动生成其他代码
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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