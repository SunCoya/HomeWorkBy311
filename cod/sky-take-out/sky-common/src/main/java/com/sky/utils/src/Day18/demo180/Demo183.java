package Day18.demo180;
import java.io.IOException;

/*
Runtime工具类：当前系统的运行环境对象
1.如何获取Runtime对象？能够new新对象吗？为什么呢？
2.如何获取当前系统线程数量？
3.如何获取能够从系统获取的最大内存，已经从系统获取到的内存，jVM剩余内存大小？
4.如何利用用Runtime写入cmd命令
*/
public class Demo183 {
    public static void main(String[] args) throws IOException {
        System.out.println("1.不能new新的Runtime对象（构造方法已经被私有化了）：故在外界只能调用同一个Runtime对象");
        Runtime runtime = Runtime.getRuntime();

        System.out.println("2.获得CPU线程数量"+runtime.availableProcessors()+"线程");

        System.out.println("3.能够从系统中获取的内存大小："+runtime.maxMemory()+"byte");
        System.out.println("已经从系统中获取的内存大小："+runtime.totalMemory()+"byte");
        System.out.println("JVM剩余内存大小————————："+runtime.freeMemory()+"byte");

        System.out.println("4.在此处使用cmd命令启动记事本");
        Runtime.getRuntime().exec("notepad");
        //Runtime.getRuntime().exec("shutdown -s -t 3600");
        //Runtime.getRuntime().exec("shutdown a");
    }
}
