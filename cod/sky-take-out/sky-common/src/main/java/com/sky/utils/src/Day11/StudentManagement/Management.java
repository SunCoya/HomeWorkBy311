package Day11.StudentManagement;

import java.util.ArrayList;
import java.util.Scanner;
//学生管理系统发：自己写的版本
public class Management {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        System.out.println("-------------欢迎来到黑马学生管理系统----------------");
        boolean flag= true;
        while (flag) {
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择:");
            try {//这里try-catch，后面再出错统一输出一句话。
                int i= new Scanner(System.in).nextInt();
                switch (i){
                    case 1->add(list);
                    case 2->delete(list);
                    case 3->change(list);
                    case 4->show(list);
                    case 5->flag=false;
                    default -> System.out.println("没有这个选项");
                }
            }catch (Exception e){
                System.out.println("输入错误！");
            }
        }
    }
    private static void add(ArrayList<Student> list){
        System.out.println("添加信息：id name age address");
        Scanner scanner = new Scanner(System.in);
        String id =scanner.next();
        for (Student student : list) {
            if (student.getId().equals(id)) {
                System.out.println("id输入重复！");
                return;
            }
        }
        String name=scanner.next();
        int age=scanner.nextInt();
        String address=scanner.next();
        Student student = new Student(id,name,age,address);
        list.add(student);
        show(list);
    }
    private static void delete(ArrayList<Student> list){
        System.out.println("删除id：");
        String id =new Scanner(System.in).next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)){
                System.out.println("id找到");
                list.remove(i);
                show(list);
                return;
            }
        }
        System.out.println("id找不到");
        show(list);
    }
    private static void change(ArrayList<Student> list){
        System.out.println("改变id：");
        String id =new Scanner(System.in).next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)){
                System.out.println("id找到");
                System.out.println("输入添加信息： name age address");
                Scanner scanner = new Scanner(System.in);
                String name=scanner.next();
                int age=scanner.nextInt();
                String address=scanner.next();
                Student student=new Student(list.get(i).getId(),name,age,address);
                list.set(i,student);
                show(list);
                return;
            }
        }
        System.out.println("id找不到");
        show(list);
    }
    private static void show(ArrayList<Student> list){
        System.out.println("--------------------------------");
        if (list.isEmpty()) {
            System.out.println("没有任何信息");
        }else {
            System.out.println("id\t姓名\t年龄\t家庭地址");
            for (Student student : list) {
                System.out.print(student.getId() + '\t' + student.getName() + '\t' + student.getAge() + '\t' + student.getAddress() + '\n');
            }
        }
        System.out.println("--------------------------------");
    }
}
