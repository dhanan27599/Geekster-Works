package Week2.Day7;

import java.util.Scanner;

public class Power_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int power = sc.nextInt();
//        System.out.println(solve(n, power));
        System.out.println(powerimp(n, power));
    }

    private static int powerimp(int x, int n) {
        if(n == 0) {
            return 1;
        }
        int temp = powerimp(x, n / 2);
        if(n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }

    private static int solve(int x, int n) {
        if(n == 0) {
            return 1;
        }

        return x * solve(x, n - 1);
    }
}
