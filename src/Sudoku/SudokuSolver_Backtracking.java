package Sudoku;

public class SudokuSolver_Backtracking {
    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        System.out.println(sudoku(board));
        for (int[] array : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
    }

    // We Can Validate & Solve Sudoku using Backtracking :)

    private static boolean sudoku(int[][] board) {
        return canSolveSudokuFromCell(0, 0, board);
    }

    private static boolean canSolveSudokuFromCell(int row, int column, int[][] board) {
        if(column == board.length) {
            row += 1;
            column = 0;

            if(row == board.length) {
                return true;
            }
        }

        if(board[row][column] != 0) {
            return canSolveSudokuFromCell(row, column + 1, board);
        }

        for(int i = 1 ; i <= board.length ; i++) {
            if(canPlaceValue(row, column, i, board)) {
                board[row][column] = i;
                if(canSolveSudokuFromCell(row, column + 1, board)) {
                    return true;
                }
                board[row][column] = 0;
            }
        }
        return false;
    }

    private static boolean canPlaceValue(int row, int column, int val, int[][] board) {
        for (int[] i : board) {
            if (i[column] == val) {
                return false;
            }
        }

        for(int i = 0 ; i < board[row].length ; i++) {
            if(board[row][i] == val) {
                return false;
            }
        }

        int region = (int) Math.sqrt(board.length);

        int verticalBoxIdx = row / region;
        int horizontalBoxIdx = column / region;

        int topLeftRow = verticalBoxIdx * region;
        int topLeftColumn = horizontalBoxIdx * region;

        for(int i = 0 ; i < region ; i++) {
            for (int j = 0; j < region; j++) {
                if (val == board[i + topLeftRow][j + topLeftColumn]) {
                    return false;
                }
            }
        }
        return true;
    }
// 8 7 val = 1 vbx = 2 hbx = 2 tlr = 6 tlc = 6
}
