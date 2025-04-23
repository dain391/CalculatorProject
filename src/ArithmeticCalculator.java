import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    // --- 속성 ---
    private List<Double> results; // 계산 결과를 저장하는 리스트

    // --- 생성자 ---
    public ArithmeticCalculator() {
        results = new ArrayList<>(); // 결과 리스트 초기화
    }

    // --- 기능 ---
    // 두 숫자와 연산자(enum)를 받아 계산을 수행하고 결과를 저장
    public double calculate(T t1, T t2, OperatorType op) {
        double n1 = t1.doubleValue(); // 제네릭 타입을 double로 변환
        double n2 = t2.doubleValue();
        double result;

        switch (op) {
            case PLUS -> result = n1 + n2;
            case MINUS -> result = n1 - n2;
            case MULTIPLY -> result = n1 * n2;
            case DIVIDE -> {
                if (n2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.\n");
                    return Double.NaN; // 0으로 나눌 경우 NaN 반환
                }
                result = n1 / n2;
            }
            default -> {
                return Double.NaN; // 잘못된 연산자 처리
            }
        }

        results.add(result); // 결과 저장
        return result;
    }

    // 저장된 결과 중 첫 번째 값을 삭제
    public void removeR() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("첫 번째 계산 결과가 삭제되었습니다.\n");
        } else {
            System.out.println("삭제할 데이터가 없습니다.");
        }
    }

    // 결과 리스트 반환
    public List<Double> getR() {
        return results;
    }

    // 결과 리스트 설정
    public void setR(List<Double> results) {
        this.results = results;
    }
}