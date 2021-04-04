package Practice.SortAlgorithms;

import java.util.Random;

public class Quick_Sort {
    public static void main(String[] args) {
        int start = (int) System.nanoTime();
        int[] arr = {8, 24, 1, 3, 5, 90, 37, 2};
        quicksort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int end = (int) System.nanoTime();
        System.out.println(end - start);
    }

    //? Helper Function

    //* Time Complexity -> O(N logN) [worst -> O(n^2)]
    //* Space Complexity -> O(1)

    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    //! Splits the array according to pivot element

    private static void quicksort(int[] arr, int left, int right) {
        if(left < right) {
            int pivot = partition(arr, left, right);
            quicksort(arr, left, pivot - 1);
            quicksort(arr, pivot + 1, right);
        }
    }

    //! Returns the pivot position to split

    private static int partition(int[] arr, int left, int right) {
        int pivot = new Random().nextInt(right);
        int pivot_idx = left - 1;
        int i;

        //! Swap Smallest Number in left of the pivot_idx

        for(i = left ; i <= right - 1 ; i++) {
            if(arr[i] <= arr[right]) {
                pivot_idx += 1;
                int temp = arr[pivot_idx];
                arr[pivot_idx] = arr[i];
                arr[i] = temp;
            }
        }

        //! Swap the pivot to the pivot_idx

        pivot_idx += 1;
        int temp = arr[pivot_idx];
        arr[pivot_idx] = arr[right];
        arr[right] = temp;

        return pivot_idx;
    }
}
