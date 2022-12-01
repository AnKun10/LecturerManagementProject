package entity;

public class Admin extends Person {
    private int id;
    private static int autoId = 0;
    //constructor
    public Admin(){ }

    public Admin(String name, int age, String username, String email, String phoneNumb, String password) {
        super(name, age, username, email, phoneNumb, password);
        this.id = ++autoId;
    }

    public int getId() {return id;}

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumb='" + phoneNumb + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
