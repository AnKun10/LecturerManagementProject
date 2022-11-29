package entity;

import java.util.ArrayList;

public class LecturerSchedule {
    private Lecturer lecturer;
    private ArrayList<Clazz> clazzes;

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public ArrayList<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(ArrayList<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    @Override
    public String toString() {
        return "LecturerSchedule{" +
                "lecturer=" + lecturer +
                ", clazzes=" + clazzes +
                '}';
    }
}
