package Dynamic_Programming;

import java.util.*;

/**
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together.
 * The problem is not actually to perform the multiplications,
 * but merely to decide in which order to perform the multiplications.
 * We have many options to multiply a chain of matrices because matrix multiplication is associative.
 * In other words, no matter how we parenthesize the product, the result will be the same.
 *
 * For example, if we had four matrices A, B, C, and D, we would have:
 * (ABC)D = (AB)(CD) = A(BCD) = ....
 * However, the order in which we parenthesize the product
 * affects the number of simple arithmetic operations needed to compute the product, or the efficiency.
 *
 * For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,
 * (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
 * A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
 *
 * Clearly the first parenthesization requires less number of operations.
 * Given an array p[] which represents the chain of matrices such that the
 * ith matrix Ai is of dimension p[i-1] x p[i].
 * We need to write a function MatrixChainOrder() that should return the minimum number of
 * multiplications needed to multiply the chain.
 *
 * Input: p[] = {40 20 30 10 30}
 * Output: 26000
 * There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
 * Let the input 4 matrices be A, B, C and D.  The minimum number of
 * multiplications are obtained by putting parenthesis in following way
 * (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
 *
 * Input: p[] = {10 20 30 40 30}
 * Output: 30000
 * There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
 * Let the input 4 matrices be A, B, C and D.  The minimum number of
 * multiplications are obtained by putting parenthesis in following way
 * ((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
 *
 * Input: p[] = {10 20 30}
 * Output: 6000
 * There are only two matrices of dimensions 10x20 and 20x30. So there
 * is only one way to multiply the matrices, cost of which is 10*20*30
 *
 */

public class Matrix_Chain_Multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(arr));
        sc.close();
    }

    //! Recursion -> High Cost
    public static int solveRecursive(int[] arr) {
        int n = arr.length;
        return solveRecursive(arr, 1, arr.length - 1);
    }

    private static int solveRecursive(int[] arr, int l, int r) {
        if(l <= r) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for(int i = l ; i < r ; i++) {
            int temp = solveRecursive(arr, l, i) +
                    solveRecursive(arr, i + 1, r) +
                    (arr[l - 1] * arr[i] * arr[r]);
            res = Math.min(res, temp);
        }
        return res;
    }


    //! Memoization -> O(n^3), Far better than recursion
    public static int solveMemoize(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return solveMemoize(arr, 1, arr.length - 1, dp);
    }

    private static int solveMemoize(int[] arr, int l, int r, int[][] dp) {
        if(l >= r) {
            return 0;
        }

        if(dp[l][r] != -1) {
            return dp[l][r];
        }

        int res = Integer.MAX_VALUE;
        for(int i = l ; i < r ; i++) {
            int temp = solveMemoize(arr, l, i, dp) +
                    solveMemoize(arr, i + 1, r, dp) +
                    (arr[l - 1] * arr[i] * arr[r]);
            res = Math.min(res, temp);
        }
        return dp[l][r] = res;
    }

    public static int solve(int[] arr) {
        int n = arr.length - 1;
        int[][] cache = new int[n][n];
        for(int len = 2 ; len <= n ; ++len){
            for(int i = 0 ; i < n - len + 1 ; i++) {
                int end = i + len - 1;
                cache[i][end] = Integer.MAX_VALUE;
                for(int j = i ; j <= end - 1 ; j++) {
                    int cost = cache[i][j] + cache[j + 1][end] + arr[i] * arr[j + 1] * arr[end + 1];
                    if(cost < cache[i][end]) {
                        cache[i][end] = cost;
                    }
                }
            }
        }
        return cache[0][n - 1];
    }
}
