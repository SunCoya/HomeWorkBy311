package Day11.StudentManagement;
import java.util.ArrayList;
import java.util.Scanner;
//学生管理系统发：看完黑马后的版本
//添加了两个方法，在完成add功能添加了contains方法判断是否使用了相同id
//在完成delete方法的时候又需要用到id对应的下标来删除，故添加getIndex功能
//这里可以把add功能中原本的代码注释掉，引用getIndex功能减少重复代码。
//先画图再敲代码，或许现在的功能实现简单，不需要，但是后期或许会需要这种习惯
public class Management2 {
    private static final int ADD_STUDENT = 1;
    private static final int DELETE_STUDENT = 2;
    private static final int UPDATE_STUDENT = 3;
    private static final int QUERY_STUDENT = 4;
    private static final int EXIT = 5;
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        System.out.println("-------------欢迎来到黑马学生管理系统----------------");
        //使用标号:跳出外层循环---相较于boolean flag设置循环终止条件更加方便高校
        loop: while (true) {
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择:");
            try {
                int i = new Scanner(System.in).nextInt();
                switch (i) {
                    case ADD_STUDENT -> add(list);
                    case DELETE_STUDENT -> delete(list);
                    case UPDATE_STUDENT -> update(list);
                    case QUERY_STUDENT -> show(list);
                    case EXIT -> {
                        System.out.println("退出系统");
                        break loop;
                        //第二种写法：System.exit(0) 或者 return;
                    }
                    default -> System.out.println("没有这个选项");
                }
            } catch (Exception e) {
                System.out.println("输入错误！");
            }
        }
    }
    private static void add(ArrayList<Student> list) {
        Scanner scanner = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("增加学生，输入id：");
            id = scanner.next();
            if (contains(list,id)){
                System.out.println("id重复，重新输入：");
            }else {
                break;
            }
        }
        System.out.println("依次输入姓名，年龄，住址");
        String name = scanner.next();
        int age = scanner.nextInt();
        String address = scanner.next();
        Student student = new Student(id, name, age, address);
        list.add(student);
        show(list);
    }
    private static void delete(ArrayList<Student> list){
        System.out.println("输入删除对象的id：");
        String id = new Scanner(System.in).next();
        if(contains(list,id)){
            System.out.println("id找到,删除成功");
            int i=getIndex(list,id);
            list.remove(i);
        }
        else {
            System.out.println("id找不到，删除失败");
        }
        show(list);
    }
    private static void update(ArrayList<Student> list) {
        System.out.println("输入改变对象的id：");
        String id = new Scanner(System.in).next();
        if (contains(list,id)){
            System.out.println("id找到:");
            System.out.println("输入添加信息：姓名，年龄，住址");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            int age = scanner.nextInt();
            String address = scanner.next();
            int i=getIndex(list,id);
            //之前我是创建新对象，再使用set修改的集合，这里直接修改对象内容，更省空间
            Student student = list.get(i);
            student.setName(name);
            student.setAge(age);
            student.setAddress(address);
            list.set(i, student);
        }else {
            System.out.println("id找不到，修改失败");
        }
        show(list);
    }
    private static void show(ArrayList<Student> list) {
        System.out.println("--------------------------------");
        if (list.isEmpty()) {
            System.out.println("没有任何信息");
        } else {
            System.out.println("id\t姓名\t年龄\t家庭地址");
            for (Student student : list) {
                System.out.print(student.getId() + '\t' + student.getName() + '\t' + student.getAge() + '\t' + student.getAddress() + '\n');
            }
        }
        System.out.println("--------------------------------");
    }
    //判断集合中是否存在该对象id
    private  static  boolean  contains(ArrayList<Student> list, String id){
        /*for (Student student : list) {
            if (student.getId().equals(id)) {
                return true;
            }
        }
        return false;*/
        if (getIndex(list,id)==-1){
            return false;
        }else return true;
    }
    //根据集合的id返回对应下标
    private static int getIndex(ArrayList<Student> list, String id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
