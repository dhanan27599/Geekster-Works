package Week3.Day8;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathsDiagonal_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solve(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
    }

    private static ArrayList<String> solve(int currentrow, int currentcolumn, int endrow, int endcolumn) {
        if(currentrow == endrow && currentcolumn == endcolumn) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if(currentrow > endrow || currentcolumn > endcolumn) {
            return new ArrayList<>();
        }

        ArrayList<String> finalresult = new ArrayList<>();

        ArrayList<String> recursiveresulthorizontal = solve(currentrow + 1, currentcolumn, endrow, endcolumn);
        for(String s : recursiveresulthorizontal) {
            finalresult.add("H" + s);
        }

        ArrayList<String> recursiveresultvertical = solve(currentrow, currentcolumn + 1, endrow, endcolumn);
        for(String s : recursiveresultvertical) {
            finalresult.add("V" + s);
        }

        ArrayList<String> recursiveresultdiag = solve(currentrow + 1, currentcolumn + 1, endrow, endcolumn);
        for(String s : recursiveresultdiag) {
            finalresult.add("D" + s);
        }

        return finalresult;
    }
}
