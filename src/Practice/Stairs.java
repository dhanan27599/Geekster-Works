package Practice;

import FastScanner.FastScanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stairs {
    static List<String> list;
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        solve(n);
        Collections.sort(list);
        System.out.println(list);
    }

    private static void solve(int n) {
        list = new ArrayList<>();
        solve(0, n, "");
    }

    private static void solve(int current, int end, String ans) {
        if(current == end) {
            list.add(ans);
            return;
        }

        for(int stairs = 1 ; stairs <= 2 ; stairs++) {
            if(current + stairs <= end) {
                solve(current + stairs, end, ans + stairs);
            }
        }
    }


}
