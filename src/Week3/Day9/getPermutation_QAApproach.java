package Week3.Day9;

import java.util.*;

public class getPermutation_QAApproach {
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

        for(int i = 0 ; i < question.length() ; i++) {
            char ch = question.charAt(i);
            String res = question.substring(0, i) + question.substring(i + 1);
            solve(res, answer + ch) ;
        }

    }
}
