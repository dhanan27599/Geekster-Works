package PriorityQueue_Ques;

import java.util.*;

public class Largest_K_Improved {
    public static void main(String[] args) {
        int[] arr = {-5, -3, 1, 2, 5, 9, 11, 5};
        int k = 2;
        solve(arr, k);
    }

    public static void solve(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr) {
            if(pq.size() == k) {
                pq.poll();
            }
            pq.add(i);
        }
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
