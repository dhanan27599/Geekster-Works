package Week2.Day7;

import java.util.Scanner;

public class Search_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i = 0 ; i < size ; i++){
            array[i] = sc.nextInt();
        }
        int search = sc.nextInt();

        System.out.println(solveimp(array, 0, search));
    }

    public static boolean solve(int[] array, int idx, int k) {
        if(idx == array.length) {
            return false;
        }
        if(solve(array, idx + 1, k)) {
            return true;
        } else {
            if(array[idx] == k) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean solveimp(int[] array, int idx, int k) {
        if(idx == array.length) {
            return false;
        }
        if(array[idx] == k) {
            return true;
        }
        return solveimp(array, idx + 1, k);
    }
}
