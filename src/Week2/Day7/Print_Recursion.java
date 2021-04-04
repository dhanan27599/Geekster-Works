package Week2.Day7;

import java.util.*;

public class Print_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        printdec(n);
//        printinc(n);
    }

    private static void printinc(int n) {
        if(n == 0) {
            return;
        }
        printinc(n - 1);
        System.out.println(n);
    }

    private static void printdec(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        printdec(n-1);
    }


}
