package Week3.Day9;

import java.util.*;

public class getSubsequence_QAApproach {
//    static List<String> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        solve(s);
//        System.out.println(list);
    }

    public static void solve(String s) {
//        list = new ArrayList<>();
        solve(s, "");
    }

    public static void solve(String question, String answer) {
        if(question.length() == 0) {
            System.out.print(answer + " ");
//            list.add(answer);
            return;
        }

        char firstchar = question.charAt(0);
        String rem = question.substring(1);

        solve(rem, answer + firstchar);
        solve(rem, answer);
    }
}
