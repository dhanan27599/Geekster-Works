package Week3.Day11;

import java.util.*;

public class PrintArrayToKSubsets_Backtracking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];

        for(int i = 0 ; i < size ; i++) {
            array[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        solve(array, k);
    }

    private static void solve(int[] array, int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        solve(array, 0, list, k);
    }

    private static void solve(int[] array, int idx, ArrayList<ArrayList<Integer>> list, int k) {
        if(idx == array.length) {
            if(list.size() == k) {
                System.out.println(list);
            }
            return;
        }

        if(list.size() == 0) {
            list.add(new ArrayList<>());
            list.get(0).add(array[idx]);
            solve(array, idx + 1, list, k);
            list.remove(0);
        } else {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).add(array[idx]);
                solve(array, idx + 1, list, k);
                list.get(i).remove(list.get(i).size() - 1); // Backtracking
            }

            if(list.size() <= k) { // Proactive Condition
                list.add(new ArrayList<>());
                list.get(list.size() - 1).add(array[idx]);
                solve(array, idx + 1, list, k);
                list.remove(list.size() - 1); // Backtracking
            }

        }
    }


}
