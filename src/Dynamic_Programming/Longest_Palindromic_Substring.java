package Dynamic_Programming;

public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String s = "abccbc";
        System.out.println(solve(s));
    }

    public static int solve(String s) {
        boolean[][] cache = new boolean[s.length()][s.length()];

        int longestPalindromeSubstring = 0;

        //! Gap Method
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < s.length(); i++, j++) {
                if (gap == 0) {
                    cache[i][j] = true;
                    longestPalindromeSubstring = 1;
                } else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        cache[i][j] = true;
                        longestPalindromeSubstring = 2;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        cache[i][j] = cache[i + 1][j - 1];
                        if (cache[i + 1][j - 1]) {
                            longestPalindromeSubstring = j - i + 1;
                        }
                    }
                }
            }
        }

        return longestPalindromeSubstring;
    }


}
