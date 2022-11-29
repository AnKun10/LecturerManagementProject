package entity;

public class Clazz {
    private String workPlace;
    private String speciality;
    private int id;
    private static int autoId = 0;

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

    public Clazz(String workPlace, String speciality, int id) {
        autoId++;
        this.id = autoId;
        this.workPlace = workPlace;
        this.speciality = speciality;
    }
}
