package Day13.demo1314;

public class Cook extends Employee{
    @Override
    public void work(){
        System.out.println("厨师做饭");
    }
    public Cook() {
    }
    Cook(String id, String name, int salary) {
        super(id, name, salary);
    }
}
