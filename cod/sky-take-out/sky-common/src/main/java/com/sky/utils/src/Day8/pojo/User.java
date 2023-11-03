package Day8.pojo;
//标准JavaBean：
//private修饰成员变量&&所有成员变量的GetSet方法&&提供至少两个构造方法
public class User {
    private String username;
    private String passport;
    private String email;
    private String sex;
    private int age;
    public User() {
    }
    public User(String username, String passport, String email, String sex, int age) {
        this.username = username;
        this.passport = passport;
        this.email = email;
        this.sex = sex;
        this.age = age;
    }
    //插件PTG快速生成标准JavaBean
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassport() {
        return passport;
    }
    public void setPassport(String passport) {
        this.passport = passport;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String toString() {
        return "User{username = " + username + ", passport = " + passport + ", email = " + email + ", sex = " + sex + ", age = " + age + "}";
    }
}
