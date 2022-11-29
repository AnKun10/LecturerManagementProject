package entity;

import java.util.ArrayList;

public class Lecturer extends Person{
    private ArrayList<String> specialities;
    private ArrayList<String> workplaces;
    private int id;
    private static int autoId = 0;

    public Lecturer(String name, int age, String username, String email, String phoneNumb, String password, ArrayList<String> specialities, ArrayList<String> workplaces) {
        super(name, age, username, email, phoneNumb, password);
        this.id = ++autoId;
        this.specialities = specialities;
        this.workplaces = workplaces;
    }

    public Lecturer() {}

    public ArrayList<String> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(ArrayList<String> specialities) {
        this.specialities = specialities;
    }

    public ArrayList<String> getWorkplaces() {
        return workplaces;
    }

    public void setWorkplaces(ArrayList<String> workplaces) {
        this.workplaces = workplaces;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "specialities=" + specialities +
                ", workplaces=" + workplaces +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumb='" + phoneNumb + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
