package Practice.SortAlgorithms;

import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = {8, 24, 1, 3, 5, 90, 37, 2};
        int[] result = mergesort(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] mergesort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        return mergesort(arr, low, high);
    }

    private static int[] mergesort(int[] arr, int low, int high) {
        if(low >= high) {
            return arr;
        }
        int mid = low + (high - low) / 2;
        int[] left_arr = Arrays.copyOfRange(arr, low, mid + 1);
        int[] right_arr = Arrays.copyOfRange(arr, mid + 1, high + 1);

        return merge(mergesort(left_arr, 0, left_arr.length - 1), mergesort(right_arr, 0, right_arr.length - 1));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }

        while (i < left.length) {
            merged[k++] = left[i++];
        }
        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return merged;
    }
}
