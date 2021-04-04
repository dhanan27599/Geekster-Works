package Week3.Day11;

import java.util.*;

public class WordBreak_BackTracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("i");
        dictionary.add("like");
        dictionary.add("sam");
        dictionary.add("sung");
        dictionary.add("samsung");
        dictionary.add("mobile");
        dictionary.add("icecream");
        dictionary.add("and");
        dictionary.add("mango");
        solve(s, dictionary);
    }

    public static void solve(String s, HashSet<String> dictionary) {
        solve(s, "", dictionary);
    }

    private static void solve(String s, String ans, HashSet<String> dictionary) {
        if(s.length() == 0) {
            System.out.println(ans);
            return;
        }

        for(int i = 0 ; i <= s.length() ; i++) {
            String cut = s.substring(0, i);
            if(dictionary.contains(cut)){
                String rest = s.substring(i);
                if(ans.length() == 0) {
                    solve(rest, ans + cut, dictionary);
                } else {
                    solve(rest, ans + " " + cut, dictionary);
                }
            }
        }
    }


}
