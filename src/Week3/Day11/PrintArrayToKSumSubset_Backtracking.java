package Week3.Day11;

import java.util.*;

public class PrintArrayToKSumSubset_Backtracking {
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
        int[] subsetsum = new int[k];
        solve(array, 0, list, k, subsetsum);
    }

    public static void solve(int[] arr, int idx, ArrayList<ArrayList<Integer>> list, int k, int[] subsetSum) {
        if (idx == arr.length) {
            if (list.size() == k) {
                for (int i = 1; i < k; i++) {
                    if (subsetSum[i] != subsetSum[i - 1]) {
                        return;
                    }
                }
                System.out.println(list);
            }
            return;
        }
        if (list.size() == 0) {
            list.add(new ArrayList<Integer>());
            list.get(0).add(arr[idx]);
            subsetSum[0] += arr[idx];
            solve(arr, idx + 1, list, k, subsetSum);
            list.remove(0);
            subsetSum[0] -= arr[idx];
        } else {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).add(arr[idx]);
                subsetSum[i] += arr[idx];
                solve(arr, idx + 1, list, k, subsetSum);
                subsetSum[i] -= arr[idx];
                list.get(i).remove(list.get(i).size() - 1);
            }

            if (list.size() < k) {
                list.add(new ArrayList<>());
                list.get(list.size() - 1).add(arr[idx]);
                subsetSum[list.size() - 1] += arr[idx];
                solve(arr, idx + 1, list, k, subsetSum);
                subsetSum[list.size() - 1] -= arr[idx];
                list.remove(list.size() - 1);
            }
        }
    }
}
