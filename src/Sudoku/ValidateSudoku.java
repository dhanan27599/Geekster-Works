package Sudoku;

import java.util.*;

/*
*
* The Most Efficient Way of Validating Sudoku
* Time Complexity -> O(mn) m = size of Row || n = size of Column
* Space Complexity -> O(kN) == O(N) k = Number of Values in Matrix
*/


public class ValidateSudoku {
    public static void main(String[] args) {

        int[][] board = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };

        System.out.println(solve(board));
    }

    public static boolean solve(int[][] board) {
        HashSet<String> seen = new HashSet<>();
        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j < 9 ; j++) {
                int val = board[i][j];
                if(val != 0) {
                    if (!seen.add(val + " found in row " + i) ||
                            !seen.add(val + " found in column " + j) ||
                            !seen.add(val + " found in box " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
