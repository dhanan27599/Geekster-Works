package Week3.Day10;

import java.util.*;

public class NQueen_Backtracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n);
    }

    private static void solve(int n) {
        boolean[][] board = new boolean[n][n];
        int row = 0;
        String ans = "";
        solve(board, row, ans);
    }

    private static void solve(boolean[][] board, int row, String ans) {
        if(row == board.length) {
            System.out.println(ans);
            return;
        }

        for(int i = 0 ; i < board[0].length ; i++) {
            if(helper(board, row, i)) {
                board[row][i] = true;
                solve(board, row + 1, ans + "(" + row + ", " + i + ")");
                board[row][i] = false;
            }
        }

    }

    private static boolean helper(boolean[][] board, int row, int column) {
        //Column
        for(int i = 0 ; i < row ; i++) {
            if(board[i][column]) {
                return false;
            }
        }

        // Diagonal Up-Left

        int r = row - 1;
        int c = column - 1;

        while(r >= 0 && c >= 0) {
            if(board[r][c]) {
                return false;
            }
            r--;
            c--;
        }

        //Diagonal Up-Right

        r = row - 1;
        c = column + 1;

        while(r >= 0 && c < board.length) {
            if(board[r][c]) {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }


}
