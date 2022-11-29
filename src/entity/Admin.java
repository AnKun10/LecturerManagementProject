package entity;

public class Admin extends Person{
    private int id;
    private static int autoId = 0;
    public Admin() {
    }

    public Admin(String name, int age){
        super(name, age);
        autoId++;
        this.id = autoId;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
