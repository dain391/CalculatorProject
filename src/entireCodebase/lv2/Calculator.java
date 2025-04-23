package entireCodebase.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // --- 속성 ---
    private List<Double> results; // 계산 결과를 저장하는 리스트

    // --- 생성자 ---
    public Calculator() {
        results = new ArrayList<>(); // 리스트 초기화
    }

    // --- 기능 ---
    // 계산 수행 메서드
    public double calculate(double n1, double n2, char op) {
        double result = 0;

        // 연산자에 따른 처리
        switch (op) {
            case '+', '➕' -> result = n1 + n2;
            case '-', '➖' -> result = n1 - n2;
            case '*', '✖' -> result = n1 * n2;
            case '/', '➗' -> {
                if (n2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.\n");
                    return Double.NaN; // 잘못된 연산 처리
                } else {
                    result = n1 / n2;
                }
            }
            default -> {
                return Double.NaN; // 존재하지 않는 연산자 처리
            }
        }

        results.add(result); // 결과 저장
        return result; // 결과 반환
    }

    // 계산 결과 중 첫 번째 값 삭제
    public void removeR() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("첫 번째 계산 결과가 삭제되었습니다.\n");
        } else {
            System.out.println("삭제할 데이터가 없습니다.");
        }
    }

    // 계산 결과 리스트 반환 (getter)
    public List<Double> getR() {
        return results;
    }

    // 계산 결과 리스트 설정 (setter)
    public void setR(List<Double> results) {
        this.results = results;
    }
}