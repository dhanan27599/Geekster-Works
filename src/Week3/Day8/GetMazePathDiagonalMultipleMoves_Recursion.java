package Week3.Day8;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathDiagonalMultipleMoves_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solve(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
    }

    private static ArrayList<String> solve(int currentrow, int  currentcolumn, int endrow, int endcolumn) {
        if(currentrow == endrow && currentcolumn == endcolumn) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if(currentrow > endrow || currentcolumn > endcolumn) {
            return new ArrayList<>();
        }

        ArrayList<String> finalresult = new ArrayList<>();

        int move = 1;
        while(move <= endcolumn) {
            ArrayList<String> recursiveresulthorizontal = solve(currentrow, currentcolumn + move, endrow, endcolumn);
            for (String s : recursiveresulthorizontal) {
                finalresult.add("H" + move + s);
            }
            move += 1;
        }

        move = 1;
        while(move <= endrow) {
            ArrayList<String> recursiveresultvertical = solve(currentrow + move, currentcolumn, endrow, endcolumn);
            for (String s : recursiveresultvertical) {
                finalresult.add("V" + move + s);
            }
            move += 1;
        }

        move = 1;
        while(move <= endrow && move <= endcolumn) {
            ArrayList<String> recursiveresultdiag = solve(currentrow + move, currentcolumn + move, endrow, endcolumn);
            for (String s : recursiveresultdiag) {
                finalresult.add("D" + move + s);
            }
            move += 1;
        }

        return finalresult;
    }
}
