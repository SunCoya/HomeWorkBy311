package Day21;

import java.util.Arrays;

public class Demo2112 {
    public static void main(String[] args) {
        System.out.println("ab".compareTo("abc"));//负数为小于，正数为大于
        GirlFriend[] girlFriends = {
                new GirlFriend("Alice", 18, 160),
                new GirlFriend("SeaLufee", 18, 160),
                new GirlFriend("Lockxi", 18, 160)
        };
        Arrays.sort(girlFriends, ((o1, o2) -> {
            double i = o1.getAge() - o2.getAge();
            i = i == 0 ? o1.getHeight() - o2.getHeight() : i;
            i = i == 0 ? o1.getName().compareTo(o2.getName()) : i;
            if (i > 0) {
                return 1;
            } else if (i < 0) {
                return -1;
            } else return 0;
        }));
        //比较了一项了，怎么在上面的基础上继续比较呢？：在lambda表达式里面进行即可
        System.out.println(Arrays.toString(girlFriends));
    }

}

class GirlFriend {
    private String name;
    private int age;
    private double height;

    public GirlFriend() {
    }

    public GirlFriend(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
