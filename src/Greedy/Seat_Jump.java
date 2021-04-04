package Greedy;

import java.util.*;

public class Seat_Jump {
    public static void main(String[] args) {
        String s = "....x..xx...x..";
//        String s = "xxx........xxxxxx";
        System.out.println(solve(s));
    }
    static int MOD = (int) 1e9 + 7;
    public static int solve(String s) {
        Vector<Integer> position = new Vector<>();
        int count = 0;
        int len = s.length();

        for(int i = 0 ; i < len ; i++) {
            if(s.charAt(i) == 'x'){
                position.add(i - count);
                count += 1;
            }
        }

        if(count == len || count == 0) {
            return 0;
        }

        int medIdx = (count - 1) / 2;

        int medVal = position.get(medIdx);

        int ans = 0;
        for(int i = 0 ; i < position.size() ; i++) {
            ans = (ans % MOD + Math.abs(position.get(i) - medVal) % MOD) % MOD;
        }
        return ans % MOD;
    }
}
