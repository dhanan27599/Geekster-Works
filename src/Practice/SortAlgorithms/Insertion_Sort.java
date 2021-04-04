package Practice.SortAlgorithms;

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] arr = {8, 24, 1, 3, 5, 90, 37, 2};
        insertionsort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void insertionsort(int[] arr) {
        int n = arr.length;

        for(int i = 1 ; i < n ; i++) {
            int value = arr[i];
            int index = i;
            while(index > 0 && arr[index - 1] > value) {
                arr[index] = arr[index - 1];
                index--;
            }
            arr[index] = value;
        }

    }
}
