package Dynamic_Programming;

public class Min_Cost_Path {
    public static void main(String[] args) {
        System.out.println(solveBottomUp(new int[][]{{1, 2, 3}, {4, 8, 2},{1, 5, 3}}));
    }

    //! Dynamic Programming - Tabulative w/ Path Tracking
    //* Bottom-Up
    public static int solveBottomUp(int[][] cost) {
        int dr = cost.length - 1;
        int dc = cost[0].length - 1;
        int k = dr;
        int l = dc;
        int[][] cache = new int[dr + 1][dc + 1];
        StringBuilder sb = new StringBuilder();
        for(int i = dr ; i >= 0 ; i--) {
            for(int j = dc ; j >= 0 ; j--) {
                if(i == dr && j == dc) {
                    cache[i][j] = cost[i][j];
                    sb.append(cost[i][j] + " ");
                } else if(i == dr) {
                    cache[i][j] = cost[i][j] + cache[i][j + 1];
                } else if(j == dc) {
                    cache[i][j] = cost[i][j] + cache[i + 1][j];
                } else {
                    cache[i][j] = Math.min(cost[i][j] + cache[i][j + 1], cost[i][j] + cache[i + 1][j]);
                }
            }

        }


        while(k >= 0 && l >= 0) {
            int min = Integer.MAX_VALUE;
            if (k - 1 >= 0 && l - 1 >= 0) {
                if(cost[k - 1][l] < cost[k][l - 1]) {
                    min = cost[k - 1][l];
                    k = k - 1;
                } else {
                    min = cost[k][l - 1];
                    l = l - 1;
                }
            } else if (k - 1 >= 0 ) {
                min = cost[k - 1][l];
                k = k - 1;
            } else if(l - 1 >= 0) {
                min = cost[k][l - 1];
                l = l - 1;
            }
            sb.append(min + " ");
            if(k == 0 && l == 0) {
                break;
            }
        }

        System.out.println(sb.reverse().toString().trim());

        return cache[0][0];
    }
    //! Dynamic Programming - Tabulative
    //* Top-Down
    public static int solveTopDown(int[][] cost) {
        int dr = cost.length - 1;
        int dc = cost[0].length - 1;
        int[][] cache = new int[dr + 1][dc + 1];

        for(int i = 0 ; i <= dr ; i++) {
            for(int j = 0 ; j <= dc ; j++) {
                if(i == 0 && j == 0) {
                    cache[i][j] = cost[i][j];
                } else if(i == 0) {
                    cache[i][j] = cost[i][j] + cache[i][j - 1];
                } else if(j == 0) {
                    cache[i][j] = cost[i][j] + cache[i - 1][j];
                } else {
                    cache[i][j] = Math.min(cost[i][j] + cache[i][j - 1], cost[i][j] + cache[i - 1][j]);
                }
            }
        }

        return cache[dr][dc];
    }
}
