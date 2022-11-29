package entity;

import java.util.ArrayList;

public class Lecturer extends Person{
    private ArrayList<String> specialities;
    private ArrayList<String> workPlaces;
    private String phoneNumb;
    private int id;
    private static int autoId = 0;

    public Lecturer() { }

    public Lecturer(String name, int age, ArrayList<String> specialities, ArrayList<String> workPlaces, String phoneNumb) {
        super(name, age);
        this.specialities = specialities;
        this.workPlaces = workPlaces;
        this.phoneNumb = phoneNumb;
        this.id = ++autoId;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

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
                ", phoneNumb='" + phoneNumb + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
