package entireCodebase.lv2;

import entireCodebase.lv3.OperatorType; // 연산자 타입 enum 클래스 import

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체
        Calculator calculator = new Calculator(); // 계산기 객체 생성

        while (true) { // 전체 반복 루프
            double n1 = 0;

            // --- 첫 번째 숫자 입력 ---
            while (true) {
                System.out.print("\n첫 번째 숫자를 입력하세요: ");
                String input = sc.next();
                try {
                    n1 = Double.parseDouble(input); // 문자열을 숫자로 변환
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                }
            }

            char op = ' '; // 문자 형태의 연산자
            OperatorType opEnum = null; // enum 형태의 연산자

            // --- 연산자 입력 ---
            while (true) {
                System.out.print("연산자(➕, ➖, ✖️, ➗)를 입력하세요: ");
                String input = sc.next();
                op = input.charAt(0); // 첫 글자만 추출
                opEnum = OperatorType.fromChar(op); // enum 변환 시도
                if (opEnum != null) {
                    break; // 유효한 연산자면 반복 종료
                } else {
                    System.out.println("잘못된 연산자입니다.\n");
                }
            }

            double n2 = 0;

            // --- 두 번째 숫자 입력 ---
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                String input = sc.next();
                try {
                    n2 = Double.parseDouble(input); // 문자열을 숫자로 변환
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
                }
            }

            // --- 계산 수행 ---
            double result = calculator.calculate(n1, n2, op);

            // --- 결과 처리/출력 ---
            if (Double.isNaN(result)) { // 0으로 나눈 경우 NaN 반환
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            } else {
                if (result == (int) result) {
                    System.out.println("\n계산 결과: " + (int) result); // 정수 출력
                } else {
                    System.out.println("\n계산 결과: " + result); // 실수 출력
                }

                // --- 결과 삭제 여부 ---
                System.out.print("계산 결과를 삭제하시겠습니까? ('yes' 입력 시 삭제): ");
                String del = sc.next();
                if (del.equals("yes")) {
                    calculator.removeR(); // 저장된 결과 삭제
                }
            }

            // --- 계속 여부 ---
            System.out.print("계속하시겠습니까?('exit' 입력 시 종료): ");
            String ans = sc.next();
            if (ans.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break; // 루프 종료
            }
        }

        sc.close();
    }
}