package Day12;
public class User {
    private String username;
    private String password;
    private String ID;
    private String phoneNumber;
    public User() {
    }
    public User(String username, String password, String ID, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String toString() {
        return "User{username = " + username + ", password = " + password + ", ID = " + ID + ", phoneNumber = " + phoneNumber + "}";
    }
}
