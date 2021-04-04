package Hackerrank_Weekly_Contest_08.Xor_Finding;
import java.io.*;
import java.util.*;

/**
 * For the given array having N elements, Find the xor of all the elements of array.
 *
 * Input Format
 * First line contain N (no of elements), second line contain N elements of Array.
 *
 * Constraints
 * 1<=N<=10^5
 * 1<=Ai<=10^9
 *
 * Output Format
 * Print xor of the array
 *
 * Sample Input 0
 * 6
 * 1 2 3 3 2 1
 *
 * Sample Output 0
 * 0
 *
 * Explanation 0
 * ((1 ^ 2 ^ 3) ^ (1 ^ 2 ^ 3)) is equals to 0.
 *
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        int res = arr[0];
        for(int i = 1 ; i < arr.length ; i++) {
            res ^= arr[i];
        }
        return res;
    }
}
