package entity;

public class User {
    protected String login;
    protected String password;
    protected String email;
    protected int age;

    public User(String login, String password, String email, int age) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
    }
    public User(String login, String password,  int age) {
        this.login = login;
        this.password = password;
        this.email = "Введите почту!";
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public int getAge() {
        return age;
    }
}
