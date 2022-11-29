package entity;

import java.util.ArrayList;

public class Lecturer extends Person{
    private ArrayList<String> specialities;
    private ArrayList<String> workPlaces;
    private int id;
    private static int autoId = 0;

    public Lecturer() {
    }

    public Lecturer(String name, int age, ArrayList<String> specialities, ArrayList<String> workPlaces) {
        super(name, age);
        autoId++;
        this.id = autoId;
        this.specialities = specialities;
        this.workPlaces = workPlaces;
    }
}
