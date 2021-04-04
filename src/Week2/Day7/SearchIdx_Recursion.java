package Week2.Day7;

import java.util.Scanner;

public class SearchIdx_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i = 0 ; i < size ; i++) {
            array[i] = sc.nextInt();
        }
        int search = sc.nextInt();

        System.out.println(solve(array, 0, search));
        System.out.println(last(array, 0, search));
    }

    public static int solve(int[] array, int idx, int k) {
        if(idx == array.length) {
            return -1;
        }

        if(array[idx] == k) {
            return idx;
        }

        return solve(array, idx + 1, k);
    }

    public static int last(int[] array, int idx, int k) {
        if(idx == array.length) {
            return -1;
        }

        int found = last(array, idx + 1, k);

        if(found == -1) {
            if(array[idx] == k) {
                return idx;
            } else {
                return -1;
            }
        } else {
            return found;
        }
    }
}
