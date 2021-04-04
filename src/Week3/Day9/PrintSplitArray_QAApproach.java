package Week3.Day9;

import java.util.*;

public class PrintSplitArray_QAApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i = 0 ; i < size ; i++) {
            array[i] = sc.nextInt();
        }
        solve(array);
    }

    public static void solve(int[] array) {
        solve(array, 0, 0, 0, "", "");
    }

    public static void solve(int[] array, int idx, int subgroup1, int subgroup2, String group1, String group2) {
        if(idx == array.length) {
            if(subgroup1 == subgroup2) {
                System.out.println(group1 + " ->" + group2);
                return;
            }

            return;
        }

        solve(array, idx + 1, subgroup1, subgroup2, group1, group2);
        solve(array, idx + 1, subgroup1 + array[idx], subgroup2, group1 + " " + array[idx], group2);
        solve(array, idx + 1, subgroup1, subgroup2 + array[idx], group1, group2 + " " + array[idx]);
    }
}
