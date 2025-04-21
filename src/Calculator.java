import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            double n1 = 0;
            while (true) {
                System.out.print("\n첫 번째 숫자를 입력하세요: ");
                String input = scanner.nextLine();
                try {
                    n1 = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                }
            }

            char op;
            while (true) {
                System.out.print("연산자(➕, ➖, ✖️, ➗)를 입력하세요: ");
                String operator = scanner.nextLine();
                if (operator.length() == 0) continue;
                op = operator.charAt(0);

                if (op == '+' || op == '-' || op == '*' || op == '/' || op == '➕' || op == '➖' || op == '✖' || op == '➗') {
                    break;
                } else {
                    System.out.println("잘못된 연산자입니다. 다시 입력해주세요.\n");
                }
            }

            double n2 = 0;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                String input = scanner.nextLine();
                try {
                    n2 = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.\n");
                }
            }

            double result = 0;
            boolean valid = true;

            switch (op) {
                case '+', '➕' -> result = n1 + n2;
                case '-', '➖' -> result = n1 - n2;
                case '*', '✖' -> result = n1 * n2;
                case '/', '➗' -> {
                    if (n2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.\n");
                        valid = false;
                    } else {
                        result = n1 / n2;
                    }
                }
            }

            if (valid) {
                if (result == (int) result) {
                    System.out.println("\n계산 결과: " + (int) result);
                } else {
                    System.out.println("\n계산 결과: " + result);
                }
            }

            System.out.print("계속하시겠습니까?('exit' 입력 시 종료): ");
            String ans = scanner.nextLine();
            if (ans.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
    }
}