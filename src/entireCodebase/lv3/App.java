package entireCodebase.lv3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            double n1 = 0;
            while (true) {
                System.out.print("\n첫 번째 숫자를 입력하세요: ");
                String input = sc.next();
                try {
                    n1 = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                }
            }

            char op = ' ';
            OperatorType opEnum = null;
            while (true) {
                System.out.print("연산자(➕, ➖, ✖️, ➗)를 입력하세요: ");
                String input = sc.next();
                op = input.charAt(0);
                opEnum = OperatorType.fromChar(op);
                if (opEnum != null) {
                    break;
                } else {
                    System.out.println("잘못된 연산자입니다.\n");
                }
            }

            double n2 = 0;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                String input = sc.next();
                try {
                    n2 = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
                }
            }

            OperatorType type = OperatorType.fromChar(op);
            double result = calculator.calculate(n1, n2, type);

            if (Double.isNaN(result)) {
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            } else {
                if (result == (int) result) {
                    System.out.println("\n계산 결과: " + (int) result);
                } else {
                    System.out.println("\n계산 결과: " + result);
                }

                System.out.print("계산 결과를 삭제하시겠습니까? ('yes' 입력 시 삭제): ");
                String del = sc.next();
                if (del.equals("yes")) {
                    calculator.removeR();
                }
            }

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