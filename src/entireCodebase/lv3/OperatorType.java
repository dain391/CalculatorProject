package entireCodebase.lv3;

public enum OperatorType {
    PLUS('+', '➕'),
    MINUS('-', '➖'),
    MULTIPLY('*', '✖'),
    DIVIDE('/', '➗');

    //속성
    private final char asc;
    private final char sym;

    //생성자
    OperatorType(char asc, char sym) {
        this.asc = asc;
        this.sym = sym;
    }

    //기능
    public static OperatorType fromChar(char op) {
        for (OperatorType type : values()) {
            if (type.asc == op || type.sym == op) {
                return type;
            }
        }
        return null;
    }
}