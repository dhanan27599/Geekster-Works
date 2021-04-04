package Stack_Questions;

import FastScanner.FastScanner;

import java.io.IOException;
import java.util.Stack;

public class InfixExpression {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        String s = fs.nextLine();
        int result = solve(s);
        System.out.println(result);
    }

    public static int solve(String expression) {
        /*
        1. if number == operand.push(number)
        2. (-> operator.push
        3. )-> operator.pop
        4. perform operation according to the precedence
         */
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(') {
                operator.push(ch);
            } else if (Character.isDigit(ch)) {
                operands.push(ch - '0');
            } else if (ch == ')') {
                while (operator.peek() != '(') {
                    char optor = operator.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int opv = operation(v1, v2, optor);
                    operands.push(opv);
                }
                operator.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operator.size() > 0 && operator.peek() != '(' && precedence(ch) <= precedence(operator.peek())) {
                    char optor = operator.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int opv = operation(v1, v2, optor);
                    operands.push(opv);
                }

                operator.push(ch);
            }

        }

        while (operator.size() > 0) {
            char optor = operator.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();
            int opv = operation(v1, v2, optor);
            operands.push(opv);
        }

        return operands.peek();
    }

    public static int precedence(char opt) {
        if (opt == '+' || opt == '-') {
            return 1;
        } else {
            return 2;
        }
    }

    public static int operation(int v1, int v2, char opt) {
        if (opt == '+') {
            return v1 + v2;
        } else if (opt == '-') {
            return v1 - v2;
        } else if (opt == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}
