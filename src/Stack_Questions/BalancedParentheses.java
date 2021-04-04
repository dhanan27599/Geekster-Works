package Stack_Questions;

import java.util.*;
import FastScanner.FastScanner;
import java.io.*;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String parentheses = sc.nextLine();
        System.out.println(solve(parentheses));
    }

    public static boolean solve(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for(char c : parentheses.toCharArray()) {
            if(c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if(c == ']' && stack.peek() == '[') {
                stack.pop();
            }  else if(c == ')' && stack.peek() == '(') {
                stack.pop();
            }  else if(c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
