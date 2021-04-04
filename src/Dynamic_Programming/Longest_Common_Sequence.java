package Dynamic_Programming;

public class Longest_Common_Sequence {
    public static void main(String[] args) {
        String first = "AGGTAB";
        String second = "GXTXAYB";
        int result = solve(first, second);
        System.out.println(result);
    }

//    public static int solveRecursive(String first, String second) {
//        if(first.length() == 0 || second.length() == 0) {
//            return 0;
//        }
//        if(first.charAt(0) == second.charAt(0)) {
//            return 1 + solveRecursive(first.substring(1), second.substring(1));
//        } else {
//            int ans1 = solveRecursive(first, second.substring(1));
//            int ans2 = solveRecursive(first.substring(1), second);
//
//            return Math.max(ans1, ans2);
//        }
//    }

    public static int solve(String first, String second) {
        int[][] cache = new int[first.length() + 1][second.length() + 1];

        for(int i = 0 ; i <= first.length() ; i++) {
            for(int j = 0 ; j <= second.length() ; j++) {
                if(i == 0 || j == 0) {
                    cache[i][j] = 0;
                } else {
                    if(first.charAt(i - 1) == second.charAt(j - 1)) {
                        cache[i][j] = cache[i - 1][j - 1] + 1;
                    } else {
                        cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                    }
                }
            }
        }

        return cache[first.length()][second.length()];
    }
}
