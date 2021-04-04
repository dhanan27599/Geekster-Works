package Week2.Day7;

import java.util.Scanner;

public class MaxArray_Recursion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];

        for(int i = 0 ; i < size ; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(maxarray(array, 0));

    }

    public static int maxarray(int[] array, int idx) {
        if(idx == array.length-1) {
            return array[idx];
        }

        int max = maxarray(array, idx+1);

        if(max > array[idx]) {
            return max;
        } else {
            return array[idx];
        }


    }
}
