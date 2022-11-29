package entity;

public class Admin extends Person{
    private String phoneNumb;
    private int id;
    private static int autoId = 0;

    public Admin() {
    }

    public Admin(String name, int age, String phoneNumb) {
        super(name, age);
        this.phoneNumb = phoneNumb;
        this.id = ++autoId;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "phoneNumb='" + phoneNumb + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
