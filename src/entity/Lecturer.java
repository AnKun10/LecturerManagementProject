package entity;

import java.util.ArrayList;

public class Lecturer extends Person{
    private ArrayList<String> specialities;
    private ArrayList<String> workPlaces;
    private int id;
    private static int autoId = 0;

    public Lecturer(String name, int age, String username, String email, String phoneNumb, String password, ArrayList<String> specialities, ArrayList<String> workPlaces) {
        super(name, age, username, email, phoneNumb, password);
        this.specialities = specialities;
        this.workPlaces = workPlaces;
        this.id = ++autoId;
    }

    public Lecturer() {}

    public ArrayList<String> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(ArrayList<String> specialities) {
        this.specialities = specialities;
    }

    public ArrayList<String> getWorkPlaces() {
        return workPlaces;
    }

    public void setWorkPlaces(ArrayList<String> workPlaces) {
        this.workPlaces = workPlaces;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "specialities=" + specialities +
                ", workPlaces=" + workPlaces +
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
