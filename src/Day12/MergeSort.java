package Day12;

import java.io.IOException;

import FastScanner.FastScanner;

public class MergeSort {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//         {38, 27, 43, 3, 9, 82, 10}
        FastScanner fs = new FastScanner();
        int size = fs.nextInt();
        int[] arr = fs.nextIntArray1(size);
        mergesort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void mergesort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        mergesort(arr, left, right);
    }

    private static void mergesort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int size1 = mid - left + 1;
        int size2 = right - mid;

        int[] first = new int[size1];
        int[] second = new int[size2];

        for(int i = 0 ; i < size1 ; i++) {
            first[i] = arr[left + i];
        }

        for(int i = 0 ; i < size2 ; i++) {
            second[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while(i < size1 && j < size2) {
            if(first[i] < second[j]) {
                arr[k++] = first[i++];
            } else {
                arr[k++] = second[j++];
            }
        }

        while(i < size1) {
            arr[k++] = first[i++];
        }

        while(j < size2) {
            arr[k++] = second[j++];
        }


    }
}
