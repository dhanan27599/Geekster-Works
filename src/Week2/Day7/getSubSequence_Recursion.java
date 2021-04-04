package Week2.Day7;

import java.util.*;

public class getSubSequence_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
    }

    private static ArrayList<String> solve(String s) {
        if(s.length() == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char firstchar = s.charAt(0);
        ArrayList<String> recursionresult = solve(s.substring(1));
        ArrayList<String> finalresult = new ArrayList<>();
        for(String str : recursionresult) {
            finalresult.add(str);
            finalresult.add(firstchar + str);
        }

        return finalresult;
    }


}
