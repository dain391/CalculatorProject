import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    // 속성
    private List<Double> results;

    // 생성자
    public ArithmeticCalculator() {
        results = new ArrayList<>();
    }

    // 기능
    public double calculate(T t1, T t2, OperatorType op) {
        double n1 = t1.doubleValue();
        double n2 = t2.doubleValue();
        double result;

        switch (op) {
            case PLUS -> result = n1 + n2;
            case MINUS -> result = n1 - n2;
            case MULTIPLY -> result = n1 * n2;
            case DIVIDE -> {
                if (n2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.\n");
                    return -1;
                }
                result = n1 / n2;
            }
            default -> {
                return -2;
            }
        }

        results.add(result);
        return result;
    }

    public void removeR() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("첫 번째 계산 결과가 삭제되었습니다.\n");
        } else {
            System.out.println("삭제할 데이터가 없습니다.");
        }
    }

    public List<Double> getR() {
        return results;
    }

    public void setR(List<Double> results) {
        this.results = results;
    }
}