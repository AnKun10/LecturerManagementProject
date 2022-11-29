package constant;

public enum TimeTableConstant {
    ODDDAYS("TUESDAY, THURSDAY, SATURDAY (6:30 P.M. -> 9:30 P.M.)"),
    EVENDAYS("MONDAY, WEDNESDAY, FRIDAY (6:30 P.M. -> 9:30 P.M.)");

    public String value;

    TimeTableConstant(String value) {this.value = value;}
}
