package constant;

public enum TimeTableConstant {
    ODDDAYS("THỨ 3,5,7 (6:30 P.M. -> 9:30 P.M.)"),
    EVENDAYS("THỨ 2,4,6 (6:30 P.M. -> 9:30 P.M.)");

    private String value;

    TimeTableConstant(String value) {this.value = value;}
}
