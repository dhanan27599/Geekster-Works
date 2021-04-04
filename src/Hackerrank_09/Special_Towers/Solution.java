package Hackerrank_09.Special_Towers;
/*
The Special Tower, is a mathematical problem which consists of three Towers and multiple Rings.
Initially, all the Rings are placed on one Tower,
one over the other in ascending order of size similar to a cone-shaped tower.

The objective of this problem is to move the stack of rings
from the initial Tower to another tower, following these rules:
A Ring cannot be placed on top of a smaller ring.
No ring can be placed on top of the smaller ring.
The goal is to move all the disks from the leftmost tower to the rightmost tower.

Input Format
First line will contain N, no of rings.

Constraints
1<=N<=30

Output Format
Print the total no of steps required to transfer the rings from first tower to third tower.

Sample Input 0
1

Sample Output 0
1

Sample Input 1
2

Sample Output 1
3

 */

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solve(new Scanner(System.in).nextInt()));
    }

    private static int count;
    public static int solve(int n) {
        count = 0;
        solve(n, 'A', 'B', 'C');
        return count;
    }

    private static void solve(int n, char a, char b, char c) {
        if(n != 0) {
            solve(n - 1, a, c, b);
            count += 1;
            solve(n - 1, c, a, b);
        }
    }
}
