package Day9.demo91;
import java.util.Random;
//该练习需要掌握的地方：
// 学会在数组中存储数据，并且存放%s用于printf的打印
//在构造方法中使用Set变量方法构造随机的成员变量
//在javaBean的方法中尽量使用.get与.set方法获取和改变成员变量
//角色类：存放变量，构造方法，GetSet方法，展示信息方法，战斗方法
public class Role {
    private String name;
    private int HP;
    private char gender;
    private String face;
    String[] boyFaces = {"风流俊雅","气宇轩昂","相貌英俊","五官端正","相貌平平","一塌糊涂","面目狰狞"};
    String[] girlFaces ={"美奂绝伦","沉鱼落雁","婷婷玉立","身材娇好","相貌平平","相貌简陋","惨不忍睹"};
    String[] attacks_desc={
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };
    String[] injured_desc={
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"
    };
    //构造方法
    public Role() {
    }
    public Role(String name, int HP,char gender) {
        this.setName(name);
        this.setHP(HP);
        this.setGender(gender);
        this.setFace();
    }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public char getGender() { return gender; }
    public void setGender(char gender) {this.gender = gender; }
    public String getFace() {return face;}
    public void setFace() {
        Random random=new Random();
        if(this.gender=='男'){
            int index=random.nextInt(boyFaces.length);
            this.face= boyFaces[index];
        }else {
            int index=random.nextInt(girlFaces.length);
            this.face= girlFaces[index];
        }
    }
    public void  showRoleInfo(){
        System.out.println(this.getName()+" "+this.getGender()+" "+this.getFace());
    }
    public void attack(Role role) {
        //如果我写的话会写两个对象参数， 这里学习一下黑马的写法
        Random random = new Random();
        //打斗数值描述：取随机伤害，并且限定数值范围
        int hurt = random.nextInt(20) + 1;
        int remainBlood = role.getHP() - hurt;
        remainBlood = remainBlood < 0 ? 0 : remainBlood;
        role.setHP(remainBlood);
        System.out.println(this.getName() + "攻击力" + role.getName() + "造成了" + hurt + "点伤害。"+role.getName() + "剩余血量为" + role.getHP());
        //打斗详情描述：攻击用随机招数，受伤根据血量判断
        int  attack=random.nextInt(attacks_desc.length);
        System.out.printf(attacks_desc[attack],this.getName(),role.getName());
        if(remainBlood>=90){
            System.out.printf(injured_desc[0],role.getName());
        }else if(remainBlood>=80){
            System.out.printf(injured_desc[1],role.getName());
        }else if(remainBlood>=70){
            System.out.printf(injured_desc[2],role.getName());
        }else if(remainBlood>=60){
            System.out.printf(injured_desc[3],role.getName());
        }else if(remainBlood>=40){
            System.out.printf(injured_desc[4],role.getName());
        }else if(remainBlood>=20){
            System.out.printf(injured_desc[5],role.getName());
        }else if(remainBlood>=10){
            System.out.printf(injured_desc[6],role.getName());
        } else{
            System.out.printf(injured_desc[7],role.getName());
        }
        System.out.println();
    }
}
