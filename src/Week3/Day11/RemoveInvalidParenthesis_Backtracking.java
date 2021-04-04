package Week3.Day11;

import java.util.*;

public class RemoveInvalidParenthesis_Backtracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        solve(s);
    }

    public static void solve(String s) {
        ArrayList<String> list = new ArrayList<>();
        solve(s, "", 0, 0, s.length(), list);
        int max = 0;
        for(String str : list) {
            max = Math.max(str.length(), max);
        }
        for(String str : list) {
            if(str.length() == max) {
                System.out.println(str);
            }
        }
    }

    public static void solve(String question, String answer, int open, int close, int initialsize, ArrayList<String> list) {
        if(close > open) {
            return;
        }

        if(open > (initialsize/2)) {
            return;
        }

        if(question.length() == 0) {
            if(open == close) {
//                System.out.println(answer);
                list.add(answer);
            }
            return;
        }

        char ch = question.charAt(0);
        String rest = question.substring(1);
        if(ch == '(') {
            solve(rest, answer + ch, open + 1, close, initialsize, list);
        } else {
            solve(rest, answer + ch, open, close + 1, initialsize, list);
        }
        solve(rest, answer, open, close, initialsize, list);
    }

}
