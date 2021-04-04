package Week1.Day3;
import java.util.*;
public class Day3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Sum Between two indices -> Prefix Sum
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int query = sc.nextInt();

        while(query-- > 0) {
            int leftIndices = sc.nextInt();
            int rightIndices = sc.nextInt();

            System.out.println(problem1(nums, leftIndices, rightIndices) == -1 ? "Invalid Input" : problem1(nums, leftIndices, rightIndices));
        }

    }

    private static int problem1(int[] nums, int i, int j) {
        int[] prefix_sum = new int[nums.length];
        int sum = 0;
        for(int k = 0 ; k < nums.length ; k++) {

            if(k == 0) {
                prefix_sum[k] = nums[k];
            } else {
                prefix_sum[k] = nums[k] + prefix_sum[k - 1];
            }
        }
        if(i < 0 || i >= nums.length || j < 0 || j >= nums.length || j < i) {
            return -1;
        }
        if(i == 0) {
            return prefix_sum[j];
        } else {
            return prefix_sum[j] - prefix_sum[i - 1];
        }
    }

    //Stack
    //Queue
}
