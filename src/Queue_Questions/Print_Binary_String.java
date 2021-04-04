package Queue_Questions;

import java.util.*;

public class Print_Binary_String {
    public static void main(String[] args) {
        int n = 10;

        System.out.println(solve(n));
    }

    private static List<String> solve(int n) {
        Deque<String> queue = new ArrayDeque<>();
        int count = 0;
        List<String> result = new ArrayList<>();
        queue.add("1");
        while(count < n) {
            result.add(queue.removeFirst());
            queue.add(result.get(result.size() - 1) + "0");
            queue.add(result.get(result.size() - 1) + "1");
            count += 1;
        }

        return result;
    }
}
