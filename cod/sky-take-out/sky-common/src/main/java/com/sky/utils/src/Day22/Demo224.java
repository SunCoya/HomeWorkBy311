package Day22;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

//lambda表达式遍历集合
public class Demo224 {
    public static void main(String[] args) {
        Collection<String> clt = new ArrayList<>();
        clt.add("爱丽丝");
        clt.add("洛琪希");
        //forEach底层
        clt.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                //s表示集合中的每一个数据
                System.out.println(s);
            }
        });
        //简写的lambda表达式
        clt.forEach(s -> System.out.println(s));
    }
}
