package Dynamic_Programming;

public class Min_Jumps {
    public static void main(String[] args) {
        int[] arr = {3, 2, 0, 2, 3, 1, 0, 1, 2, 0, 1};
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        int[] jumps = new int[arr.length];
        jumps[0] = 0;

        for(int i = 1 ; i < arr.length ; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < i ; j++) {
                if(arr[j] >= i - j) {
                    min = Math.min(min, jumps[j]);
                }
            }
            jumps[i] = min + 1;
        }

        return jumps[jumps.length - 1];
    }

}
