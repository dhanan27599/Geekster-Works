package PriorityQueue_Ques;

import java.util.*;

public class Almost_Sorted {
    public static void main(String[] args) {
        int[] arr = {30, 10, 40, 20, 50, 70, 80, 60, 110, 90, 100, 120};
        int k = 2;
        solve(arr, k);
    }

    public static void solve(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < arr.length ; i++) {
            if(i < k + 1) {
                pq.add(arr[i]);
            } else {
                arr[i - k - 1] = pq.poll();
                pq.add(arr[i]);
            }
        }

        for(int i = arr.length - k - 1 ; i < arr.length ; i++) {
            arr[i] = pq.poll();
        }

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
