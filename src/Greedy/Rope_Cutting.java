package Greedy;

import java.util.*;

public class Rope_Cutting {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 3, 8, 6);
        System.out.println(solve(arr));
    }

    public static int solve(List<Integer> ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(ropes);
        int minCost = 0;
        while(pq.size() != 1) {
            int sum = pq.poll() + pq.poll();
            minCost += sum;
            pq.add(sum);
        }

        return minCost;
    }
}
