package Dynamic_Programming;

public class Coin_Change {
    public static void main(String[] args) {
        int n = 7;
        int[] coins = {2, 3, 5};
        System.out.println(solvePermutation(coins, n));
        System.out.println(solveCombination(coins, n));
    }

    public static int solvePermutation(int[] coins, int target) {
        int[] cache = new int[target + 1];

        cache[0] = 1;
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    cache[i] += cache[i - coins[j]];
                }
            }
        }

        return cache[cache.length-1];
    }

    public static int solveCombination(int[] coins, int target) {
        int[] cache = new int[target + 1];

        cache[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < cache.length; j++) {
                if (j - coins[i] >= 0) {
                    cache[j] += cache[j - coins[i]];
                }
            }
        }

        return cache[cache.length - 1];
    }
}
