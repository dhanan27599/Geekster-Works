package Week2.Day7;

import java.util.*;
public class getPermutation_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> list = new ArrayList<>();
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
            for(int i = 0 ; i <= str.length() ; i++) {
                finalresult.add(str.substring(0, i) + firstchar + str.substring(i));
            }
        }

        return finalresult;
    }

}
