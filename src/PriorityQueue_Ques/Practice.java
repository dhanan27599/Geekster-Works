package PriorityQueue_Ques;
import java.util.*;
public class Practice {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(-1);
        System.out.println(pq.poll());
        System.out.println(pq);
    }
}
