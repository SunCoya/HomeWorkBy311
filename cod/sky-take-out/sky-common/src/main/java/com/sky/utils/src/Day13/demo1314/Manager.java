package Day13.demo1314;

public class Manager extends Employee{
    private int managementPrice;
    @Override
    public void work(){
        System.out.println("管理其他人");
    }
    public Manager() {
    }
    public Manager(String id, String name, int salary, int managementPrice) {
        super(id, name, salary);
        this.managementPrice = managementPrice;
    }
    public int getManagementPrice() {
        return managementPrice;
    }
    public void setManagementPrice(int managementPrice) {
        this.managementPrice = managementPrice;
    }
}
