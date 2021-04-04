package Hackerrank_Weekly_Contest_08.Magical_Rope_2;
import java.io.*;
import java.util.*;

/**
 * Sachin has a rope, its length is n.
 * He wants to cut the rope in a way that fulfils the following two conditions:
 *
 * After the cutting, each rope piece should have length a, b or c.
 * After the cutting, the number of rope pieces should be maximum.
 * Help Sachin and find the number of rope pieces after the required cutting.
 *
 * Input Format
 * The first line contains four space-separated integers n, a, b and c
 * (1 ≤ n, a, b, c ≤ 4000) — the length of the original rope
 * and the acceptable lengths of the rope pieces after the cutting,
 * correspondingly. The numbers a, b and c can coincide.
 *
 * Constraints
 * (1 ≤ n, a, b, c ≤ 4000)
 *
 * Output Format
 * Print a single number — the maximum possible number of rope pieces.
 * It is guaranteed that at least one correct ribbon cutting exists.
 *
 * Sample Input 0
 * 5 5 3 2
 *
 * Sample Output 0
 * 2
 *
 * Explanation 0
 * the first piece has length 2, the second piece has length 3.
 *
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(solve(n, a, b, c));
    }

    public static int solve(int n, int a, int b, int c) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        int x = 0, y = 0, z = 0;

        for(int i = 1 ; i <= n ; i++) {
            x = y = z = -1;
            if(i >= a) {
                x = cache[i - a];
            }

            if(i >= b) {
                y = cache[i - b];
            }

            if(i >= c) {
                z = cache[i - c];
            }

            if(x == -1 && y == -1 && z == -1) {
                cache[i] = -1;
            } else {
                cache[i] = Math.max(Math.max(x, y), z) + 1;
            }
        }
        return cache[n];
    }
}
