package Week3.Day8;

import java.util.*;
public class GetBoardParts_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(0, n));
    }

    private static ArrayList<String> solve(int current, int end) {
        if(current == end) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if(current > end) {
            return new ArrayList<>();
        }
        ArrayList<String> finalresult = new ArrayList<>();

        for(int dice = 1 ; dice <= 6 ; dice++) {
            ArrayList<String> recursiveresult = solve(current + dice, end);
            for(String str : recursiveresult) {
                finalresult.add(dice + str);
            }
        }

        return finalresult;
    }


}
