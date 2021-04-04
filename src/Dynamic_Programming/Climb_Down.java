package Dynamic_Programming;

public class Climb_Down {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(solve(n));
        System.out.println(solveTabulate(n));
        System.out.println(solveMemoize(n, new int[n + 1]));
    }

    //! Recursion
    public static int solve(int n) {
        if(n < 0) {
            return 0;
        }

        if(n == 1 || n == 0) {
            return 1;
        }

        return solve(n - 1) + solve(n - 2) + solve(n - 3);
    }

    //! Dynamic Programming - Memoization
    public static int solveMemoize(int n, int[] cache) {
        if(n < 0) {
            return 0;
        }

        if(n == 0 || n == 1) {
            return 1;
        }

        if(cache[n] != 0) {
            return cache[n];
        }
        return cache[n] = solve(n - 1) + solve(n - 2) + solve(n - 3);
    }

    //! Dynamic Programming - Tabulation
    public static int solveTabulate(int n) {
        int[] cache = new int[n + 1];

        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;

        for(int i = 3 ; i <= n ; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }

        return cache[n];
    }
}
