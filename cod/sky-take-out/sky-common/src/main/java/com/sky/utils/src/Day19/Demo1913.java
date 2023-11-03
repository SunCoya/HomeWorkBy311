package Day19;

/*
捕获分组与非捕获分组
1.什么是捕获分组？
2.什么是非捕获分组？
3.非捕获分组与捕获分组的不同点？
4.那些表示非捕获分组呢？
*/
public class Demo1913 {
    public static void main(String[] args) {
        System.out.println("1.捕获分组：后续还要使用本组的数据，前面的 \\\\与$都是捕获分组");
        System.out.println("2.非捕获分组：分组之后不需要使用本组数据，就仅仅括起来而已");
        System.out.println("3.非捕获分组要点就是，不占用组号，不能使用\\\\与$再次表达数据");
        System.out.println("4.比如之前用过的(?:)这个是捕获所有数据，但是不是捕获分组。相同的还有(?=)(?<=)(?!)");
        System.out.println("在下列案例中不能使用：\\\\1来表示分组");
        System.out.println("123456789".matches("(?:.)"));
    }
}
