package RuffleSort;

import java.util.*;

public class Ruffle {
    public static void sort(int[] array) {

        int n = array.length;
        Random rand = new Random();

        for(int i = 0 ; i < n ; i++) {
            int j = rand.nextInt(n);
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }

        Arrays.sort(array);
    }
}
