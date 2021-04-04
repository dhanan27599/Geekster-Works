package Day12;

// Move the values lesser than pivot element

public class PivotPartition {
    public static void main(String[] args) {
        int[] array = {10, 80, 20, 30, 90, 70};
        solve(array);
        for(int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void solve(int[] array) {
        partition(array, 0, array.length - 1);
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for(int j = low ; j < high ; j++) {
            if(array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
