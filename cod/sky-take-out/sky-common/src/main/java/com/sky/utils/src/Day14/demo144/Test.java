package Day14.demo144;
/*
继承、多态练习：看一遍就行
1.思考：对于不同的动物，这里使用了方法的重载，写了两个不同的keepPet方法，如何简化？
解决：在方法的参数类型使用父类对象（也就是运用多态）
2.想办法在keepPet中调用Dog和Cat的特别方法
解决：在方法中把父类对象强制转换成子类对象
*/
public class Test {
    public static void main(String[] args) {
        new Person("老王", 30).keepPet(new Dog(2, "黑色"), "骨头");
        new Person("老李", 25).keepPet(new Cat(3, "灰色"), "鱼");
    }
}
