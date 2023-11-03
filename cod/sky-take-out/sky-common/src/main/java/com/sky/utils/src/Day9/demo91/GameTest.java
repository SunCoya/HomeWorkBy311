package Day9.demo91;
//文字版格斗游戏
public class GameTest {
    public static void main(String[] args) {
        //初始化变量
        Role role1 = new Role("小军", 100,'女');
        Role role2 = new Role("小红", 100,'男');
        //展示角色信息
        role1.showRoleInfo();
        role2.showRoleInfo();
        //进行战斗
        while (true) {
            role1.attack(role2);
            if (role2.getHP() == 0) {
                System.out.println(role1.getName() + "击败了" + role2.getName());
                break;
            }
            role2.attack(role1);
            if (role1.getHP() == 0) {
                System.out.println(role2.getName() + "击败了" + role1.getName());
                break;
            }
        }
    }
}
