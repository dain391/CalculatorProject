package entireCodebase.lv3;

import java.util.Scanner;

public class App {
    // --- 기능 ---
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체 생성
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>(); // Double 타입 전용 계산기 객체 생성

        while (true) {
            // 첫 번째 숫자 입력
            double n1 = 0;
            while (true) {
                System.out.print("\n첫 번째 숫자를 입력하세요: ");
                String input = sc.next();
                try {
                    n1 = Double.parseDouble(input); // 문자열을 double로
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                }
            }

            // 연산자 입력 및 검증
            char op = ' ';
            OperatorType opEnum = null;
            while (true) {
                System.out.print("연산자(➕, ➖, ✖️, ➗)를 입력하세요: ");
                String input = sc.next();
                op = input.charAt(0); // 첫 문자만 추출
                opEnum = OperatorType.fromChar(op); // 문자에 해당하는 열거형 값 조회
                if (opEnum != null) {
                    break;
                } else {
                    System.out.println("잘못된 연산자입니다.\n");
                }
            }

            // 두 번째 숫자 입력
            double n2 = 0;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                String input = sc.next();
                try {
                    n2 = Double.parseDouble(input); // 문자열을 double로
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
                }
            }

            // 계산 실행
            OperatorType type = OperatorType.fromChar(op);
            double result = calculator.calculate(n1, n2, type);

            // 결과 출력 또는 오류 처리
            if (Double.isNaN(result)) {
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            } else {
                if (result == (int) result) {
                    System.out.println("\n계산 결과: " + (int) result); // 정수 출력
                } else {
                    System.out.println("\n계산 결과: " + result); // 실수 출력
                }

                // 결과 삭제 여부
                System.out.print("계산 결과를 삭제하시겠습니까? ('yes' 입력 시 삭제): ");
                String del = sc.next();
                if (del.equals("yes")) {
                    calculator.removeR(); // 첫 번째 결과 삭제
                }
            }

            // 종료 여부
            System.out.print("계속하시겠습니까?('exit' 입력 시 종료): ");
            String ans = sc.next();
            if (ans.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
        sc.close();
    }
}