package Dynamic_Programming;

public class Longest_Palindromic_Subsequence {
    public static void main(String[] args) {
        String s = "ababdab";
        int result = solve(s);
        System.out.println(result);
    }

    public static int solveRecursive(String str) {
        return solveRecursive(str, new StringBuilder(str).reverse().toString());
    }

    private static int solveRecursive(String s, String r) {
        if(s.length() == 0 || r.length() == 0) {
            return 0;
        }

        if(s.charAt(0) == r.charAt(0)) {
            return 1 + solveRecursive(s.substring(1), r.substring(1));
        } else {
            int ans1 = solveRecursive(s, r.substring(1));
            int ans2 = solveRecursive(s.substring(1), r);
            return Math.max(ans1, ans2);
        }
    }

    public static int solve(String s) {
        return solve(s, new StringBuilder(s).reverse().toString());
    }

    private static int solve(String s, String r) {
        int[][] cache = new int[s.length() + 1][r.length() + 1];
        for(int i = 0 ; i <= s.length() ; i++) {
            for(int j = 0 ; j <= r.length() ; j++) {
                if(i == 0 || j == 0) {
                    cache[i][j] = 0;
                } else if(s.charAt(i - 1) == r.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                }
            }
        }
        return cache[s.length()][r.length()];
    }
}
