package Dynamic_Programming;

public class Rod_Cutting {
    public static void main(String[] args) {
        int[] arr = {0, 3, 5, 6, 15, 10, 25, 12, 24};
        System.out.println(solve(arr));
    }

    public static int solve(int[] cost) {
        int[] cache = new int[cost.length];

        cache[0] = cost[0];
        cache[1] = cost[1];

        for(int i = 2 ; i < cost.length ; i++) {
            int max = cost[i];
            int j = 1;
            int k = i - 1;
            while(j <= k) {
                max = Math.max(max, cache[j++] + cache[k--]);
            }
            cache[i] = max;
        }
        return cache[cache.length - 1];
    }

}
