package Week2.Day7;

import java.util.Scanner;

public class PrintArray_Recursivon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];

        for(int i = 0 ; i < size ; i++) {
            array[i] = sc.nextInt();
        }

        solve(array);
        reverse(array);
    }

    public static void solve(int[] array) {
        solve(array, 0);
    }

    public static void solve(int[] array, int idx) {
        if(idx == array.length) {
            return;
        }
        System.out.println(array[idx]);
        solve(array, idx + 1);
    }

    public static void reverse(int[] array) {
        reverse(array, 0);
    }

    public static void reverse(int[] array, int idx) {
        if(idx == array.length) {
            return;
        }
        reverse(array, idx + 1);
        System.out.println(array[idx]);
    }
}
