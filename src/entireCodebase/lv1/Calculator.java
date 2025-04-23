package entireCodebase.lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 입력을 위한 Scanner 객체

        while (true) { // 반복적인 계산
            double n1 = 0;
            // 첫 번째 숫자 입력
            while (true) {
                System.out.print("\n첫 번째 숫자를 입력하세요: ");
                String input = scanner.nextLine();
                try {
                    n1 = Double.parseDouble(input); // 숫자로 변환
                    break; // 성공 시 반복 종료
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                }
            }

            char op;
            // 연산자 입력
            while (true) {
                System.out.print("연산자(➕, ➖, ✖️, ➗)를 입력하세요: ");
                String operator = scanner.nextLine();
                if (operator.length() == 0) continue; // 빈 입력 무시
                op = operator.charAt(0); // 문자열에서 첫 글자만 추출하여 연산자 설정

                // 유효한 연산자인 경우 반복 종료
                if (op == '+' || op == '-' || op == '*' || op == '/' ||
                        op == '➕' || op == '➖' || op == '✖' || op == '➗') {
                    break;
                } else {
                    System.out.println("잘못된 연산자입니다. 다시 입력해주세요.\n");
                }
            }

            double n2 = 0;
            // 두 번째 숫자 입력
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                String input = scanner.nextLine();
                try {
                    n2 = Double.parseDouble(input); // 숫자 변환 시도
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.\n");
                }
            }

            double result = 0; // 계산 결과 저장
            boolean valid = true; // 유효한 계산 여부

            // 연산 수행
            switch (op) {
                case '+', '➕' -> result = n1 + n2;
                case '-', '➖' -> result = n1 - n2;
                case '*', '✖' -> result = n1 * n2;
                case '/', '➗' -> {
                    if (n2 == 0) {
                        // 0으로 나눌 경우 오류 메시지 출력
                        System.out.println("0으로 나눌 수 없습니다.\n");
                        valid = false;
                    } else {
                        result = n1 / n2;
                    }
                }
            }

            // 결과 출력
            if (valid) {
                if (result == (int) result) { // 결과가 정수인 경우 정수로
                    System.out.println("\n계산 결과: " + (int) result);
                } else { // 소수점 포함된 결과는 소수로
                    System.out.println("\n계산 결과: " + result);
                }
            }

            // 계속 여부
            System.out.print("계속하시겠습니까?('exit' 입력 시 종료): ");
            String ans = scanner.nextLine();
            if (ans.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break; // 'exit' 입력 시 종료
            }
        }
    }
}