package constant;

public enum TimetableConstant {
    ODDDAYS("TUESDAY, THURSDAY, SATURDAY (6:30 P.M. -> 9:30 P.M.)"),
    EVENDAYS("MONDAY, WEDNESDAY, FRIDAY (6:30 P.M. -> 9:30 P.M.)");

    public String value;

    TimetableConstant(String value) {this.value = value;}
}
