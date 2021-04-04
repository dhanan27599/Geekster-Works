package HashMap_Questions;
import java.util.*;
public class Two_Sum {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 0, 20, 19, 5};
//        int[] result = solve(arr, 21);
//        System.out.println(result[0] + " " + result[1]);
        System.out.println(solve(arr, 21));
    }

    private static List<List<Integer>> solve(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++) {
            if(set.contains(target - arr[i])) {
                result.add(Arrays.<Integer>asList(arr[i], target - arr[i]));
            }
            set.add(arr[i]);
        }
        return result;
    }
}
