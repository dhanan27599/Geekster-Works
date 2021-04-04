package HashMap_Questions;

import java.util.*;

public class Longest_Sequence {
    public static void main(String[] args) {
        int[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i : arr) {
            map.put(i, false);
        }

        for(int i : arr) {
            if(!map.containsKey(i - 1)) {
                map.replace(i, true);
            }
        }
        int max = 0;
        int idx = -1;

        for(int i : arr) {
            int count = 1;
            if(map.get(i)) {
                while(map.containsKey(i + count)) {
                    count += 1;
                }
                if(count > max) {
                    max = count;
                    idx = i;
                }
            }
        }
        System.out.println("Index = " + idx);
        return max;
    }
}
