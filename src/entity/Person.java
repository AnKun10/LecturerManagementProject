package entity;

public abstract class Person {
    protected String name;
    protected int age;
    protected String username;
    protected String email;
    protected String phoneNumb;
    protected String password;

    public Person(String name, int age, String username, String email, String phoneNumb, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.email = email;
        this.phoneNumb = phoneNumb;
        this.password = password;
    }

    public Person() { }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumb='" + phoneNumb + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
