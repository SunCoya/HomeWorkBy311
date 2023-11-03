package Day14.demo141;

public class Administrator extends Person{
    @Override
    public  void  show(){
        System.out.println("管理者信息为："+name+" "+age);
    }
    public Administrator() { }
    public Administrator(String name, int age) {
        super(name, age);
    }
}
