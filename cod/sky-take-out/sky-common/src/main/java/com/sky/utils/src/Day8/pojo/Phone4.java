package Day8.pojo;
//构造方法：在创建对象的时候给成员变量进行初始化（赋值），这样可以不用GetSet方法进行赋值
//构造方法注意事项：方法名与类名一致，没有返回值，也不能写void，不能自己在测试类中写来调用，它是在创建对象时虚拟机自动调用的
//构造方法推荐写法：手动书写无参构造和带全部参数的构造方法
public class Phone4 {
    private String brand;
    public Phone4(){//无参构造方法,里面可以不写东西
        System.out.println("新对象被创建啦！");
    }
    public Phone4(String brand){//有参构造（构造方法也可以方法重载）
        this.brand=brand;
    }
    public String getBrand() {
        return brand;
    }
}
