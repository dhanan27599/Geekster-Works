package Dynamic_Programming;

public class Gold_Mines {
    public static void main(String[] args) {
        int[][] goldmine = {{10, 33, 13, 15}, {22, 21, 4, 1}, {5, 0, 2, 3}, {0, 6, 14, 2}};
        System.out.println(solve(goldmine));
    }

    public static int solve(int[][] goldmine) {
        int rowmax = goldmine.length - 1;
        int colmax = goldmine[0].length - 1;

        int[][] costs = new int[rowmax + 1][colmax + 1];

        for(int i = 0 ; i <= rowmax ; i++) {
            costs[i][colmax] = goldmine[i][colmax];
        }

        for(int j = colmax - 1 ; j >= 0 ; j--) {
            for(int i = 0 ; i <= rowmax ; i++) {
                if(i == 0) {
                    int max = Math.max(costs[i][j + 1], costs[i + 1][j + 1]);
                    costs[i][j] = goldmine[i][j] + max;
                } else if(i == rowmax) {
                    int max = Math.max(costs[i][j + 1], costs[i - 1][j + 1]);
                    costs[i][j] = goldmine[i][j] + max;
                } else {
                    int max = Math.max(costs[i + 1][j + 1], Math.max(costs[i - 1][j + 1], costs[i][j + 1]));
                    costs[i][j] = goldmine[i][j] + max;
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i <= rowmax ; i++) {
            max = Math.max(costs[i][0], max);
        }

        return max;
    }
}
