package PriorityQueue_Ques;

import java.util.*;

public class MergeKSortedList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(Arrays.asList(10,20,30,40,50)));
        lists.add(new ArrayList<>(Arrays.asList(5,10,15,20,25)));
        lists.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        lists.add(new ArrayList<>(Arrays.asList(3,6,9,12)));
        solve(lists);
    }

    private static void solve(ArrayList<ArrayList<Integer>> lists) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0;i<lists.size();i++){
            pair p = new pair(i, 0, lists.get(i).get(0));
//            p.dataIdx = 0;
//            p.lIdx = i;
//            p.value = lists.get(i).get(0);
            pq.add(p);
        }

        while(pq.size()>0){
            pair p = pq.remove();
            System.out.print(p.value+" ");
            if(p.dataIdx < lists.get(p.lIdx).size() - 1) {
                pair p2 = new pair(p.lIdx, p.dataIdx + 1, lists.get(p.lIdx).get(p.dataIdx));
//                p2.lIdx = p.lIdx;
//                p2.dataIdx = p.dataIdx + 1;
//                p2.value = lists.get(p.lIdx).get(p.dataIdx);
                pq.add(p2);
            }
        }
    }

    static class pair implements Comparable<pair>{
        int lIdx;
        int dataIdx;
        int value;

        public pair(int lidx, int dataIdx, int value) {
            this.lIdx = lidx;
            this.dataIdx = dataIdx;
            this.value = value;
        }

        @Override
        public int compareTo(pair o) {
            return this.value - o.value;
        }
    }
}
