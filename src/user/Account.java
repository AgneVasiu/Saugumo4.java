package user;

public class Account {

    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUserName() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}