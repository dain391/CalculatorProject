package entireCodebase.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Double> results;

    public Calculator() {
        results = new ArrayList<>();
    }

    public double calculate(double n1, double n2, char op) {
        double result = 0;
        switch (op) {
            case '+', '➕' -> result = n1 + n2;
            case '-', '➖' -> result = n1 - n2;
            case '*', '✖' -> result = n1 * n2;
            case '/', '➗' -> {
                if (n2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.\n");
                    return Double.NaN;
                } else {
                    result = n1 / n2;
                }
            }
            default -> {
                return Double.NaN;
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