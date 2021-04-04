package Greedy;

import java.lang.reflect.Array;
import java.util.*;

public class Activity_Selection {
    public static void main(String[] args) {
        List<pair> list = Arrays.asList(new pair(10, 20), new pair(5, 40), new pair(20, 30));
        solve(list);
    }

    public static void solve(List<pair> list) {
        Collections.sort(list);

        System.out.println(list.get(0));

        for (int i = 1 ; i < list.size() ; i++) {
            pair current = list.get(i);
            pair previous = list.get(i - 1);
            int ps = previous.start;
            int pe= previous.end;
            int cs = current.start;
            int ce = current.end;
            if (pe <= cs) {
                System.out.println(current);
            }
        }
    }

    static class pair implements Comparable<pair>{
        int start;
        int end;

        public pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(pair o) {
            return this.end - o.end;
        }

        @Override
        public String toString() {
            return new StringBuilder("[" + start + ", " + end + "]").toString();
        }
    }
}
