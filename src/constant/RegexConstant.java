package constant;

public enum RegexConstant {
    PASSWORD("^\\w{7,15}$"),
    EMAIL("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$"),
    PHONENUMBER("^0\\d{9,10}$"),
    NAME("");

    public String value;

    RegexConstant(String value){this.value = value;}
}
