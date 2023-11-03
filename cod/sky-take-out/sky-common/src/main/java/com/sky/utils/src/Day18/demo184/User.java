package Day18.demo184;

import java.util.Arrays;

class User implements Cloneable{
    private int id;
    private String name;
    private String passwd;
    private int[] data;
    public User() {
    }
    public User(int id, String name, String passwd, int[] data) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.data = data;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public int[] getData() {
        return data;
    }
    public void setData(int[] data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}