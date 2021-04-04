package Dynamic_Programming;

public class Max_Sum_No_Adjacent {
    public static void main(String[] args) {
        int[] arr = {5, 6, 10, 100, 10, 5};
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
//        int[] exclude = new int[arr.length];
//        int[] include = new int[arr.length];
//        exclude[0] = 0;
//        include[0] = arr[0];
//        for(int i = 1 ; i < arr.length ; i++) {
//            exclude[i] = Math.max(exclude[i - 1], include[i - 1]);
//            include[i] = arr[i] + exclude[i - 1];
//        }
//
//        return Math.max(include[arr.length - 1], exclude[arr.length - 1]);

        int exclude = 0;
        int include = arr[0];

        for(int i = 1 ; i < arr.length ; i++) {
            int prevexc = exclude;
            exclude = Math.max(exclude, include);
            include = arr[i] + prevexc;
        }

        return Math.max(include, exclude);
    }
}
