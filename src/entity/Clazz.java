package entity;

public final class Clazz {
    private String workplace;
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

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
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

    public Clazz(String workplace, String speciality, String timetable) {
        this.id = ++autoId;
        this.workplace = workplace;
        this.speciality = speciality;
        this.timetable = timetable;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "workplace='" + workplace + '\'' +
                ", speciality='" + speciality + '\'' +
                ", timetable='" + timetable + '\'' +
                ", id=" + id +
                '}';
    }
}
