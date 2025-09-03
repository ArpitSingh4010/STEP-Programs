import java.util.Scanner;

public class Q4{

    // validate expression
    public static boolean validateExpression(String expr) {
        int parentheses = 0;
        char prev = ' ';
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            // valid characters: digits, + - * / ( ) and space
            if (!((c >= '0' && c <= '9') || c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == ' ')) {
                return false;
            }

            if (c == '(') parentheses++;
            if (c == ')') parentheses--;

            // invalid parentheses
            if (parentheses < 0) return false;

            // operator placement check
            if ((c == '+' || c == '-' || c == '*' || c == '/') &&
                    (prev == '+' || prev == '-' || prev == '*' || prev == '/' || prev == '(')) {
                return false;
            }

            if (c != ' ') prev = c;
        }
        return parentheses == 0;
    }

    // evaluate simple expression without parentheses
    public static int evaluateSimple(String expr, StringBuilder steps) {
        expr = expr.trim().replaceAll(" +", " ");

        // parse numbers and operators into arrays
        String[] parts = expr.split(" ");
        int n = (parts.length + 1) / 2;
        int[] numbers = new int[n];
        char[] ops = new char[n - 1];

        for (int i = 0, j = 0, k = 0; i < parts.length; i++) {
            if (i % 2 == 0) {
                numbers[j++] = Integer.parseInt(parts[i]);
            } else {
                ops[k++] = parts[i].charAt(0);
            }
        }

        // first handle * and /
        for (int i = 0; i < ops.length; i++) {
            if (ops[i] == '*' || ops[i] == '/') {
                int result = (ops[i] == '*') ? numbers[i] * numbers[i + 1] : numbers[i] / numbers[i + 1];
                steps.append(expr).append(" => ").append(result).append("\n");

                numbers[i] = result;
                for (int j = i + 1; j < n - 1; j++) numbers[j] = numbers[j + 1];
                for (int j = i; j < ops.length - 1; j++) ops[j] = ops[j + 1];
                n--;
                i--;
            }
        }

        // then handle + and -
        int result = numbers[0];
        for (int i = 0; i < n - 1; i++) {
            if (ops[i] == '+') result += numbers[i + 1];
            else result -= numbers[i + 1];
            steps.append(expr).append(" => ").append(result).append("\n");
        }
        return result;
    }

    // handle parentheses
    public static int evaluateExpression(String expr, StringBuilder steps) {
        while (expr.contains("(")) {
            int close = expr.indexOf(")");
            int open = expr.lastIndexOf("(", close);
            String inside = expr.substring(open + 1, close);
            int val = evaluateSimple(inside, steps);
            expr = expr.substring(0, open) + val + expr.substring(close + 1);
        }
        return evaluateSimple(expr, steps);
    }

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter mathematical expressions (type 'exit' to stop):");

        while (true) {
            System.out.print("\nExpression: ");
            String expr = sc.nextLine();
            if (expr.equalsIgnoreCase("exit")) break;

            if (!validateExpression(expr)) {
                System.out.println("Invalid Expression ❌");
                continue;
            }

            StringBuilder steps = new StringBuilder();
            int result = evaluateExpression(expr, steps);

            System.out.println("\n--- Calculation Steps ---");
            System.out.println("Original: " + expr);
            System.out.println(steps.toString());
            System.out.println("Final Result = " + result);
        }
    }
}
