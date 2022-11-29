package constant;

public enum TimetableConstant {
    ODDDAYS("THỨ 3,5,7 (6:30 P.M. -> 9:30 P.M.)"),
    EVENDAYS("THỨ 2,4,6 (6:30 P.M. -> 9:30 P.M.)");

    public String value;

    TimetableConstant(String value) {this.value = value;}
}
