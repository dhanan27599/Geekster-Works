package Week2.Day7;

import java.util.Scanner;

public class Fibonacci_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }

    public static int solve(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return solve(n - 1) + solve(n - 2);
    }
}
