package Practice;

import FastScanner.FastScanner;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;

public class MergeIntervalSize {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] arr = fs.nextIntMatrix(n, 2);
        System.out.println(solve(arr));
    }

    private static int solve(int[][] arr) {
        if(arr.length <= 1) {
            return arr.length;
        }
        Arrays.sort(arr, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> list = new ArrayList<>();
        int[] current_arr = arr[0];
        list.add(current_arr);
        for(int[] i: arr) {
            int current_start = current_arr[0];
            int current_end = current_arr[1];
            int next_start = i[0];
            int next_end = i[1];

            if(current_end >= next_start) {
                current_arr[1] = Math.max(current_end, next_end);
            } else {
                current_arr = i;
                list.add(current_arr);
            }
        }

        return list.size();
    }
}
