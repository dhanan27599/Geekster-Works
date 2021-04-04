package Hackerrank_09.Perfect_Numbers;
/*
Sachin got a task from his teacher,
as sachin is weak in maths help him to solve the following task.
Given a positive integer n,
find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Input Format
First line contain N, as described above.

Constraints
1<=N<=10^5

Output Format
print least number of perfect squares which sum it to N.

Sample Input 0
12

Sample Output 0
3

Explanation 0
4+4+4 sums upto 12.

 */

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        System.out.println(solve(new Scanner(System.in).nextInt()));
    }

    public static int solve(int n) {
        if(n <= 3) {
            return n;
        }
        int res;
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 3;

        for(int i = 4 ; i <= n ; i++) {
            cache[i] = i;
            int limit = (int) Math.ceil(Math.sqrt(i));
            for(int x = 1 ; x <= limit ; x++) {
                int temp = x * x;
                if(temp > i) {
                    break;
                } else {
                    cache[i] = Math.min(cache[i], cache[i - temp] + 1);
                }
            }
        }
        return res = cache[n];
    }

}
