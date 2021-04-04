package Dynamic_Programming;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};

        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        int[] res = new int[arr.length];

        res[0] = 1;

        for(int i = 1 ; i < arr.length ; i++) {
            int max = 0;
            for(int j = 0 ; j < i ; j++) {
                if(arr[j] < arr[i]) {
                    max = Math.max(res[j], max);
                }
            }

            res[i] = max + 1;
        }

        int ans = Integer.MIN_VALUE;

        for(int i : res) {
            ans = Math.max(i, ans);
        }

        return ans;
    }
}
