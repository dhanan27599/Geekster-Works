package Dynamic_Programming;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(solveDP(n, new int[n + 1]));
        System.out.println(solve(n));

    }
    //! Recursion
    public static int solve(int n) {
        if(n == 1 || n == 2) {
            return n - 1;
        }

        int fib1 = solve(n - 1);
        int fib2 = solve(n - 2);

        int fibn = fib1 + fib2;

        return fibn;
    }


    //! Dynamic Programming - Memoization
    public static int solveDP(int n, int[] cache) {
        if(n == 1 || n == 2) {
            return n - 1;
        }

        if(cache[n] != 0) {
            return cache[n];
        }

        int fib1 = solveDP(n - 1, cache);
        int fib2 = solveDP(n - 2, cache);

        int fibn = fib1 + fib2;
        cache[n] = fibn;
        return fibn;
    }


}
