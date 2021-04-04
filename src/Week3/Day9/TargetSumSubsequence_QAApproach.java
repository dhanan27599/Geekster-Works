package Week3.Day9;

import java.util.*;

public class TargetSumSubsequence_QAApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i = 0 ; i < size ; i++) {
            array[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        solve(array, target);
    }

    public static void solve(int[] array, int target) {
        solve(array, 0, target, "");
    }

    private static void solve(int[] array, int idx, int target, String answer) {
        if(idx == array.length) {

            if(target == 0) {
                System.out.println(answer);
                return;
            }

            return;
        }

        solve(array, idx + 1, target - array[idx], answer + " " + array[idx]);
        solve(array, idx + 1, target, answer);
    }


}
