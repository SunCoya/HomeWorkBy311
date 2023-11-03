package Day13.demo1314;
//带有继承结构的标准javabean类:
//在这个案例中需要注意的是，manager类的带全部参数的构造方法。先super父类，再赋值多出来的参数
public class Test {
    public static void main(String[] args) {
        Manager manager = new Manager("001","zhangsan",15000,8000);
        System.out.println(manager.getId()+" "+manager.getName()+" "+manager.getSalary()+" "+manager.getManagementPrice());
        Cook cook = new Cook("002","lisi",8000);
        System.out.println(cook.getId()+" "+cook.getName()+" "+cook.getSalary());
    }
}
