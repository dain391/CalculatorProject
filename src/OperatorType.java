public enum OperatorType {
    PLUS('+', '➕'),
    MINUS('-', '➖'),
    MULTIPLY('*', '✖'),
    DIVIDE('/', '➗');

    // --- 속성 ---
    private final char asc; // 일반 아스키 연산자
    private final char sym; // 이모지 형태의 연산자

    // --- 생성자 ---
    OperatorType(char asc, char sym) {
        this.asc = asc;
        this.sym = sym;
    }

    // --- 기능 ---
    // 전달받은 문자와 일치하는 연산자 타입 반환
    public static OperatorType fromChar(char op) {
        for (OperatorType type : values()) {
            if (type.asc == op || type.sym == op) {
                return type;
            }
        }
        return null; // 해당하는 연산자가 없을 경우 null 반환
    }
}