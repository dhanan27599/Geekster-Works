package HashMap_Questions;

import java.util.*;

public class Get_Common_Elements {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 3, 5, 5};
        int[] arr2 = {2, 2, 3, 3, 5, 5};
        System.out.println(solve(arr, arr2));
    }

    private static ArrayList<Integer> solve(int[] arr, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int i : arr2) {
            if(map.containsKey(i)) {
                result.add(i);
                map.remove(i);
            }
        }

        return result;
    }
}
