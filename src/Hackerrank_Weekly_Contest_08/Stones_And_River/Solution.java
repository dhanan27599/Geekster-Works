package Hackerrank_Weekly_Contest_08.Stones_And_River;
import java.util.*;

/**
 *You want to cross the river and there are N stones on the way to cross the river.
 *
 * Each time you can jump either 1 or 2 stones,
 * You are curious to know in how many distinct ways you can cross the river.
 *
 * Find the number of distinct ways to cross the river.
 *
 * Input Format
 * First line contain N, no of stones.
 *
 * Constraints
 * 1<=N<=45
 *
 * Output Format
 * Print the total no of distinct ways to cross the river.
 *
 * Sample Input 0
 * 2
 *
 * Sample Output 0
 * 2
 *
 * Explanation 0
 * Possible ways are the following subset:- {1,1},{2}
 *
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(solve(new Scanner(System.in).nextInt()));
    }

    public static int solve(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for(int i = 2 ; i <= n ; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}
