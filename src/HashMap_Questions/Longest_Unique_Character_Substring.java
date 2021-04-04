package HashMap_Questions;

import java.util.HashMap;

public class Longest_Unique_Character_Substring {
    public static void main(String[] args) {
        String s = "dhananjayan";
        System.out.println(solve(s));
    }

    private static int solve(String s) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int j = 0 ; j < s.length() ; j++) {
            if(map.containsKey(s.charAt(j))) {
                start = Math.max(start, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j - start + 1);
        }
        return max;
    }
}
