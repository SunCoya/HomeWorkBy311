package Day9.demo93;
//问题一：数组对象中空指针不能遍历，并且报错,这里使用了一个非空判断,而且下面的静态函数有很多都用到了非空判断。
//问题二：他这里和我的想法不同的是要开辟新数组并且复制到新数组，我觉得这种算法不太好，不如C中的链表,这个知识点到后面学习
//问题三：视频中第四题第五题，老师用的是获取下标再更改数据，但是由于这里的id不是字符串，直接用属性id也可以，我没有按老师的做了，不过这个思路是一定要知道的。
public class StudentTest {
    //创建长度为三的学生对象数组，并且创建对象放入数组
    //再次创建对象并且放入数组，其中得判断id是否重复，数组是否已满,最后打印
    public static void main(String[] args) {
        Student[] students=new Student[3];
        Student student1=new Student(1,"zimo",20);
        Student student2=new Student(2,"baiyi",20);
        Student student3=new Student(3,"yutian",20);
        students[0]=student1;
        students[1]=student2;
        students[2]=student3;
        Student student4=new Student(4,"sale",20);

        boolean flag = contains(students,student4.getId());

        int count=getCount(students);

        if(flag){//id重复
            System.out.println("当前id重复");
        }else{//id不重复
            if(students.length==count){//数组长度到达最大，创建新数组并替换旧数组
                Student[] newStudents=createNew(students);
                students=newStudents;
                students[count]=student4;
                print(students);
            }else{//数组长度未达到最大
                students[count]=student4;
                print(students);
            }
        }
    }
    public  static boolean contains(Student[] students,int id){
        //判断对象数组中是否有对象有某id的
        for (int i = 0; i < students.length; i++) {
            if (students[i]!=null){
                if(students[i].getId()==id){
                    return true;
                }
            }
        }
        return false;
    }
    public static int getCount(Student[] students){
        //计算对象数组中的对象个数
        int count=0;
        for (int i = 0; i < students.length; i++){
            if(students[i]!=null){
                count++;
            }
        }
        return count;
    }
    public static Student[] createNew(Student[] students){
        //创建比原先对象数组多一个位置的新对象数组并且赋值
        Student[] arr=new Student[students.length+1];
        for (int i = 0; i < students.length; i++) {
            arr[i]=students[i];
        }
        return arr;
    }
    public  static void print(Student[] students){
        //打印对象数组
        for (int i = 0; i < students.length; i++) {
            if (students[i]!=null){
                System.out.println(students[i]);
            }
        }
    }
}
