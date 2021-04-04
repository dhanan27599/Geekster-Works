package Dynamic_Programming;

public class Knapsack_01 {
    public static void main(String[] args) {
        int[] values = {15, 10, 20, 100};
        int[] weights = {1, 2, 3, 5};
        int threshold = 8;
        int[][] cache = new int[weights.length + 1][threshold + 1];

//        System.out.println(solveRecursive(values, weights, threshold, weights.length));
        System.out.println(unboundKnapsack(values, weights, threshold, weights.length, cache));
//        System.out.println(solveBottomUp(values, weights, threshold, weights.length, cache));
//        System.out.println(solveTopDown(values, weights, threshold, weights.length));
    }

    public static int solveRecursive(int[] values, int[] weights, int threshold, int n) {
        if(n == 0 || threshold == 0) {
            return 0;
        }

        if(weights[n - 1] > threshold) {
            int exclude = solveRecursive(values, weights, threshold, n - 1);
            return exclude;
        }

        int include = solveRecursive(values, weights, threshold - weights[n - 1], n - 1) + values[n - 1];
        int exclude = solveRecursive(values, weights, threshold, n - 1);

        return Math.max(include, exclude);
    }

    public static int solveBottomUp(int[] values, int[] weights, int threshold, int n, int[][] cache) {
        if(n == 0 || threshold == 0) {
            return 0;
        }

        if(cache[n][threshold] != 0) {
            return cache[n][threshold];
        }

        if(weights[n - 1] > threshold) {
            int exclude = solveBottomUp(values, weights, threshold, n - 1,cache);
            return exclude;
        }

        int include = solveBottomUp(values, weights, threshold - weights[n - 1], n - 1, cache) + values[n - 1];
        int exclude = solveBottomUp(values, weights, threshold, n - 1, cache);

        return cache[n][threshold] = Math.max(include, exclude);
    }

    public static int solveTopDown(int[] values, int[] weights, int threshold, int n) {
        int[][] cache = new int[weights.length + 1][threshold + 1];

        for(int i = 0 ; i <= weights.length ; i++) {
            for(int j = 0 ; j <= threshold ; j++) {
                if (i == 0) {
                    cache[i][j] = 0;
                } else if (j == 0) {
                    cache[i][j] = 0;
                } else {
                    if (j >= weights[i - 1]) {
                        cache[i][j] = Math.max(cache[i - 1][j], cache[i - 1][j - weights[i - 1]] + values[i - 1]);
                    } else {
                        cache[i][j] = cache[i - 1][j];
                    }
                }
            }
        }

        return cache[weights.length][threshold];
    }

    public static int unboundKnapsack(int[] values, int[] weights, int threshold, int n, int[][] cache) {
        if(n == 0 || threshold == 0) {
            return 0;
        }

        if(cache[n][threshold] != 0) {
            return cache[n][threshold];
        }

        if(weights[n - 1] > threshold) {
            int exclude = unboundKnapsack(values, weights, threshold, n - 1,cache);
            return exclude;
        }

        int include = unboundKnapsack(values, weights, threshold - weights[n - 1], n, cache) + values[n - 1];
        int exclude = unboundKnapsack(values, weights, threshold, n - 1, cache);

        return cache[n][threshold] = Math.max(include, exclude);
    }
}
