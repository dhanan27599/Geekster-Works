package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;

public class Minimum_Palindrome_Cut {
    public static void main(String[] args) {
        String s = "abccbc";
        System.out.println(solve(s));
    }

    public static int solve(String s) {
        int[][] cache = new int[s.length()][s.length()];
//        boolean[][] isPalindrome = longestPalindromicSubstring(s);

        //! Gap Method
        for(int gap = 0 ; gap < s.length() ; gap++) {
            for(int i = 0 , j = gap ; j < s.length() ; i++, j++) {
                if(gap == 0) {
                    cache[i][j] = 0;
                } else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)) {
                        cache[i][j] = 0;
                    } else {
                        cache[i][j] = 1;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j) && cache[i + 1][j - 1] == 0) {
                        cache[i][j] = 0;
                    } else {
                        int min = Integer.MAX_VALUE;
                        for(int i_ = i + 1, j_ = j - gap ; j_ < j ; i_++, j_++) {
                            min = Math.min(min, cache[i][j_] + cache[i_][j] + 1);
                        }
                        cache[i][j] = min;
                    }
                }
            }
        }

        return cache[0][s.length() - 1];
    }

//    public static boolean[][] longestPalindromicSubstring(String s) {
//        boolean[][] cache = new boolean[s.length()][s.length()];
//
//        int longestPalindromeSubstring = 0;
//
//        //! Gap Method
//        for (int gap = 0; gap < s.length(); gap++) {
//            for (int i = 0, j = gap; j < s.length(); i++, j++) {
//                if (gap == 0) {
//                    cache[i][j] = true;
//                    longestPalindromeSubstring = 1;
//                } else if (gap == 1) {
//                    if (s.charAt(i) == s.charAt(j)) {
//                        cache[i][j] = true;
//                        longestPalindromeSubstring = 2;
//                    }
//                } else {
//                    if (s.charAt(i) == s.charAt(j)) {
//                        cache[i][j] = cache[i + 1][j - 1];
//                        if (cache[i + 1][j - 1]) {
//                            longestPalindromeSubstring = j - i + 1;
//                        }
//                    }
//                }
//            }
//        }
//
//        return cache;
//    }
}
