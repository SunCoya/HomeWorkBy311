package Day19;

/*
正则表达式：数量控制
1.如何使字符出现的的次数为0或1？
2.如何使字符出现次数为0到无穷？
3.如何使字符出现次数至少为1次？
4.如何使字符只出现n次？
5.如何使字符出现至少n次？
6.如何使字符出现至少m次，至多n次？
*/
public class Demo193 {
    public static void main(String[] args) {
        System.out.println("1.出现次数：0-1，“？”代表有没有这个数呢？有或者是没有，可以理解成0或者1");
        System.out.println("".matches("\\w?"));
        System.out.println("R".matches("\\w?"));
        System.out.println("RR".matches("\\w?"));

        System.out.println("2.出现次数：0-无穷，”*“代表我不知道这里有多少个，或者是有多少，反正不可能是负数吧");
        System.out.println("".matches("\\w*"));
        System.out.println("RRRRRRR".matches("\\w*"));

        System.out.println("3.出现次数：1-无穷，“+”代表至少有一个");
        System.out.println("".matches("\\w+"));
        System.out.println("R".matches("\\w+"));
        System.out.println("RRRRRR".matches("\\w+"));

        System.out.println("4.出现次数：n次，“{}”代表范围，没有两个数则代表刚好有n个数，有逗号隔开则代表有范围");
        System.out.println("RRR".matches("\\w{5}"));
        System.out.println("RRRRR".matches("\\w{5}"));

        System.out.println("5.出现次数：至少m次");
        System.out.println("RRR".matches("\\w{5,}"));
        System.out.println("RRRRR".matches("\\w{5,}"));
        System.out.println("RRRRRRR".matches("\\w{5,}"));

        System.out.println("6.出现次数：至少m至多n");
        System.out.println("RRR".matches("\\w{5,10}"));
        System.out.println("RRRRRRR".matches("\\w{5,10}"));
        System.out.println("RRRRRRRRRRR".matches("\\w{5,10}"));
    }
}