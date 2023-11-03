package Day13.demo1314;

public class Employee {
    private String id;
    private String name;
    private int salary;
    public void work(){}
    public void eat(){System.out.println("吃米饭");}
    public Employee() {}
    public Employee(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
