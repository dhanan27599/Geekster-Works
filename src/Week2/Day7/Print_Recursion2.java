package Week2.Day7;

import java.util.Scanner;

public class Print_Recursion2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n);
    }

    public static void solve(int n) {
        if(n == 0) {
            return;
        }
        if(n % 2 != 0) {
            System.out.println("Hi" + n);
            solve(n - 1);
        }
        else {
            solve(n-1);
            System.out.println("Bye" + n);
        }
    }
}
