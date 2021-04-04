package Dynamic_Programming;

public class Target_Sum_Subset {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 6};
        int target = 10;

        System.out.println(solve(arr, target));
    }

    public static boolean solve(int[] arr, int target) {
        boolean[][] cache = new boolean[arr.length + 1][target + 1];

        for(int i = 0 ; i < cache.length ; i++) {
            for(int j = 0 ; j < cache[0].length ; j++) {
                if(i == 0 && j == 0) {
                    cache[i][j] = true;
                } else if(i == 0) {
                    cache[i][j] = false;
                } else if(j == 0) {
                    cache[i][j] = true;
                } else if(cache[i - 1][j] == true) {
                    //! Checking: whether excluding myself forms sum(j val)
                    cache[i][j] = true;
                } else if(j - arr[i - 1] >= 0) {
                    //! Checking: including myself forms sum(j val)
                    cache[i][j] = cache[i - 1][j - arr[i - 1]];
                }
            }
        }

        return cache[cache.length - 1][cache[0].length - 1];
    }
}
