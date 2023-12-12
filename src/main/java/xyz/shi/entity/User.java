package xyz.shi.entity;
public class User {
    private int id;
    private String name;
    private String password;
    public int getId() {
        return id;
    }
    // 因为QueryRunner创建Bean对象的过程使用的是newInstance()方法，该方法只能调用无参构
    public  User () {

    }
    public User(int id,String name, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
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
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

}