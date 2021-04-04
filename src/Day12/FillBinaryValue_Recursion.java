package Day12;

import java.util.Scanner;

public class FillBinaryValue_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        solve(s);
    }

    public static void solve(String s) {
        solve(s, new StringBuilder(""), 0);
    }

    public static void solve(String question, StringBuilder answer, int idx) {
        if(idx == question.length()){
            System.out.println(answer.toString());
            return;
        }

        char ch = question.charAt(idx);
        if(ch != '?') {
            answer.append(ch);
            solve(question, answer, idx + 1);
            answer.deleteCharAt(answer.length() - 1);
        } else {
            answer.append("0");
            solve(question, answer, idx + 1);
            answer.deleteCharAt(answer.length() - 1);
            answer.append("1");
            solve(question, answer, idx + 1);
            answer.deleteCharAt(answer.length() - 1);
        }
    }
}
