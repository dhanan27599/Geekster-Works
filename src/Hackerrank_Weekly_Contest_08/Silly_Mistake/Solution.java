package Hackerrank_Weekly_Contest_08.Silly_Mistake;
import java.io.*;
import java.util.*;

/**
 * Your final English exam paper has a weird question on string matching.
 *
 * You were given a long string S and a word W.
 *
 * You were required to find the number of occurrences of the word in the string.
 *
 * In hurry, you made a silly mistake.
 *
 * If a substring of the given string matched the given word (letter by letter)
 * with atmost one letter off (one letter incorrectly substituted),
 * you counted it as a valid occurrence of the word in the string.
 *
 * You realized your mistake after coming home and want to know
 * how many times you counted the word in the sentence to know
 * how much you’d be penalized and decide to
 * write a program to do the same for you to ease the task.
 *
 * Input Format
 * The first line of input contains a string S (1 ≤ |S| ≤ 10^3 )
 * denoting the string given to you in your exam.
 * The second line contains the word W (1 ≤ |W | ≤ |S|)
 * denoting the word whose occurrences had to be found in the string S.
 * Both S and W will consist of lowercase letters.
 *
 * Constraints
 * (1 ≤ |S| ≤ 10^3)
 * (1 ≤ |W| ≤ |S|)
 *
 * Output Format
 * Output a single integer X,
 * denoting the number of times you counted the word in the string
 * (both correctly and incorrectly)
 *
 * Sample Input 0
 * thisissometeststringimadeup
 * et
 *
 * Sample Output 0
 * 5
 *
 * Explanation 0
 * In this given testcase, you match the input word five times,
 * first with et, second with es and third with st,
 * fourth with st again and finally with eu.
 *
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String w = sc.next();
        System.out.println(solve(s, w));
    }

    public static int solve(String s, String w) {
        int count = 0;

        for(int i = 0 ; i < s.length() - w.length() ; i++) {
            int c = 0;
            for(int j = 0, k = i ; j < w.length() ; j++, k++) {
                char a = s.charAt(k);
                char b = w.charAt(j);
                if(a == b) {
                    c += 1;
                }
            }
            if(c >= w.length() - 1) {
                count += 1;
            }
        }

        return count;
    }
}
