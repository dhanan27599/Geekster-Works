package Stack_Questions;

import FastScanner.FastScanner;

import java.io.IOException;
import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        String exp = fs.nextLine();
        System.out.println(solve(exp));
    }

    private static String solve(String exp) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : exp.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static int precedence(char opt) {
        if (opt == '+' || opt == '-') {
            return 1;
        } else if(opt == '*' || opt == '/') {
            return 2;
        } else if(opt == '('){
            return -1;
        } else {
            return 3;
        }
    }
}
