package Stack_Questions;

import FastScanner.FastScanner;

import java.io.IOException;
import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) throws IOException {
//        System.out.println(solve(Arrays.asList(new Interval(4, 7), new Interval(2, 4), new Interval(8, 9), new Interval(4, 6))));
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] arr = fs.nextIntMatrix(n, 2);
        int[][] result = solve(arr);

        for(int[] array : result) {
            for(int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static boolean isEqual(int[][] result, int[][] res) {
        if(res.length != result.length) {
            return false;
        }
        for(int i = 0 ; i < res.length ; i++) {
            for(int j = 0 ; j < res[i].length ; j++) {
                if(result[i][j] != res[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

//    public static Stack<Interval> solve(List<Interval> list) {
//        Collections.sort(list);
//        Stack<Interval> result = new Stack<>();
//        for(Interval it : list) {
//            if(result.isEmpty()) { result.push(it); }
//            else if(result.peek().end < it.start) { result.push(it); }
//            else if (result.peek().end < it.end){
//                result.peek().end = it.end;
//            }
//        }
//        return result;
//    }
//
//    static class Interval implements Comparable<Interval> {
//        int start;
//        int end;
//
//        Interval(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        public int compareTo(Interval o) {
//            return this.start - o.start;
//        }
//
//        @Override
//        public String toString() {
//            return (this.start + " " +this.end);
//        }
//    }
// Without Using Intervals Class

    private static int[][] solve(int[][] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        Arrays.sort(arr, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> list = new ArrayList<>();
        int[] current_arr = arr[0];
        list.add(current_arr);
        for (int[] i : arr) {
            int current_start = current_arr[0];
            int current_end = current_arr[1];
            int next_start = i[0];
            int next_end = i[1];

            if (current_end >= next_start) {
                current_arr[1] = Math.max(current_end, next_end);
            } else {
                current_arr = i;
                list.add(current_arr);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
