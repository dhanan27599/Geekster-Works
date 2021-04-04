package Dynamic_Programming;

public class Edit_Distance {
    public static void main(String[] args) {
        String str1 = "geeks";
        String str2 = "gesek";
//        System.out.println(solveRecursive(str1, str2));
        System.out.println(solve(str1, str2));
    }

    //! Recursion is costly but important :)
    public static int solveRecursive(String str1, String str2) {
        return solveRecursive(str1, str2, str1.length(), str2.length());
    }

    private static int solveRecursive(String str1, String str2, int m, int n) {

        if(m == 0) {
            return n;
        }

        if(n == 0) {
            return m;
        }

        if(str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return solveRecursive(str1, str2, m - 1, n - 1);
        } else {
            return Math.min(solveRecursive(str1, str2, m, n - 1),
                    Math.min(solveRecursive(str1, str2, m - 1, n),
                            solveRecursive(str1, str2, m - 1, n - 1))) + 1;
        }
    }


    //! Tabulation -> Optimized
    public static int solve(String str1, String str2) {
        return solve(str1, str2, str1.length(), str2.length());
    }

    private static int solve(String str1, String str2, int m, int n) {
        int[][] cache = new int[m + 1][n + 1];

        for(int i = 0 ; i <= m ; i++) {
            for(int j = 0 ; j <= n ; j++) {
                if(i == 0) {
                    cache[i][j] = j;
                } else if(j == 0) {
                    cache[i][j] = i;
                } else if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    cache[i][j] = cache[i - 1][j - 1];
                } else {
                    cache[i][j] = Math.min(cache[i - 1][j], Math.min(cache[i][j - 1], cache[i - 1][j - 1])) + 1;
                }
            }
        }

        return cache[m][n];
    }
}
