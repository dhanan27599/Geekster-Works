package PriorityQueue_Ques;

import java.util.*;

public class Largest_K_Elements {
    public static void main(String[] args) {
        int[] arr = {-5, -3, 1, 2, 5, 9, 11, 5};
        int k = 3;
        solve(arr, k);
    }

    public static void solve(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr) {
            pq.add(i);
        }
        while(k-- > 0) {
            System.out.println(pq.poll());
        }
    }
}
