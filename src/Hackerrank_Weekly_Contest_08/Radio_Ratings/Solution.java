package Hackerrank_Weekly_Contest_08.Radio_Ratings;

import java.util.*;

/**
 * Radio Jockey called in sick today,
 * so you have to play songs in his time slot and
 * maximise rating based on previously available data.
 * You have 3 available songs. and Data suggests:
 *
 * 1. If you play song A in ith hour then you'll get ai rating.
 * 2. for song B, bi rating.
 * 3. for song C, ci rating.
 * you cannot play same song for for two consecutive times.
 *
 * Find maximum rating after N hours.
 *
 * Input Format
 * N
 * A1 B1 C1
 * A2 B2 C2
 * A3 B3 C3
 * . .
 * . .
 * . .
 * upto N lines
 *
 * Constraints
 * All values in input are integers.
 * 1<=N<=10^5
 * 1<=Ai,Bi,Ci<=10^4
 *
 * Output Format
 * Print single integer k i.e maximum ratings
 *
 * Sample Input 0
 * 3
 * 10 40 70
 * 20 50 80
 * 30 60 90
 *
 * Sample Output 0
 * 210
 *
 * Explanation 0
 * maximum ratings are in order of 70+50+90.
 *
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < 3 ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solve(arr));
    }

    public static int solve(int[][] rate) {
        int n = rate.length;
        int[][] dp = new int[rate.length][3];

        for(int j = 0; j < 3 ; j++){
            dp[0][j] = rate[0][j];
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(j == 0){
                    dp[i][j] = Math.max(dp[i-1][1], dp[i-1][2]);
                }else if(j == 1){
                    dp[i][j] = Math.max(dp[i-1][0], dp[i-1][2]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][0], dp[i-1][1]);
                }
                dp[i][j] += rate[i][j];
            }
        }
        int ans=0;
        ans = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
        return ans;
    }
}