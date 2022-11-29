package entity;

public class Clazz {
    private String workPlace;
    private String speciality;
    private String timetable;
    private int id;
    private static int autoId = 0;

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getId() {
        return id;
    }

    public Clazz(String workPlace, String speciality, String timetable) {
        this.id = ++autoId;
        this.workPlace = workPlace;
        this.speciality = speciality;
        this.timetable = timetable;
    }
}
