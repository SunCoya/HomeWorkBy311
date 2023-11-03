package Day11.ArrayList;

import java.util.ArrayList;

//Arraylist方法:增add删remove改set查get长度size
public class demo112 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //添加元素
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println("添加元素：" + list);
        //删除元素：根据内容删除
        boolean result = list.remove("aaa");
        System.out.println("删除一个元素aaa，输出删除判断：" + result);//result返回结果，删除成功则为true，失败则为false
        System.out.println("删除一个元素aaa，输出结果：" + list);
        //删除元素：根据索引删除
        String str = list.remove(2);
        System.out.println("删除索引2，返回被删除的元素：" + str);
        System.out.println("删除索引2，输出删除后的结果" + list);
        //修改元素:根据索引修改
        str = list.set(1, "ddd");
        System.out.println("改变索引1，返回被改变的原来的元素：" + str);
        System.out.println("改变索引1，bbb->ddd:输出结果：" + list);
        //查询元素：根据索引查询
        str = list.get(0);
        System.out.println("查询索引0：返回元素：" + str);
        //遍历集合
        System.out.println("遍历集合：使用list.size（）获取长度");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
