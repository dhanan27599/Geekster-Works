package Week3.Day10;

import java.util.*;

// Lexicography - Dictionary Order

public class PrintLexicographically_Backtracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n);
    }

    private static void solve(int n) {
        int num = 1;
        int max = n;
        solve(num, max);
    }

    private static void solve(int num, int max) {
        if(num <= max)
            System.out.println(num);

        for (int i = 0 ; i <= 9 ; i++) {
            if(num * 10 + i <= max) {
                solve(num * 10 + i, max);
            }
        }

        if(num < 9) {
            solve(num + 1, max);
        }
    }

}
