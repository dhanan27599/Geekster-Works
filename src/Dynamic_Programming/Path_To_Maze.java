package Dynamic_Programming;

public class Path_To_Maze {
    public static void main(String[] args) {
        System.out.println(solveBottomUp(2, 2));
        System.out.println(solveTopDown(2, 2));
    }

    //! Dynamic Programming - Tabulation
    //* Top-down
    public static int solveTopDown(int dr, int dc) {
        int[][] cache = new int[dr + 1][dc + 1];

        for(int i = 0 ; i <= dr ; i++) {
            for (int j = 0 ; j <= dc ; j++) {
                if(i == 0 && j == 0) {
                    cache[i][j] = 1;
                } else if(i == 0) {
                    cache[i][j] = cache[i][j - 1];
                } else if(j == 0) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
                }
            }
        }

        return cache[dr][dc];
    }

    //! Dynamic Programming - Tabulation
    //* Bottom-Up
    public static int solveBottomUp(int dr, int dc) {
        int[][] cache = new int[dr + 1][dc + 1];

        for(int i = dr ; i >= 0 ; i--) {
            for(int j = dc ; j >= 0 ; j--) {
                if(i == dr && j == dc) {
                    cache[dr][dc] = 1;
                } else if(i == dr) {
                    cache[i][j] = cache[i][j + 1];
                } else if(j == dc) {
                    cache[i][j] = cache[i + 1][j];
                } else {
                    cache[i][j] = cache[i + 1][j] + cache[i][j + 1];
                }
            }
        }

        return cache[0][0];
    }


}
