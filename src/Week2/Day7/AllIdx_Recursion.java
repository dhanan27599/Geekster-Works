package Week2.Day7;

import java.util.Scanner;

public class AllIdx_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];

        for(int i = 0 ; i < size ; i++) {
            array[i] = sc.nextInt();
        }
        int data = sc.nextInt();

        int[] result = solve(array, 0, data, 0);

        for(int i = 0 ; i < result.length ; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] solve(int[] array, int idx, int data, int fsf) {
        if(idx == array.length) {
            return new int[fsf];
        }
        if(array[idx] == data) {
            int[] result = solve(array, idx + 1, data, fsf + 1);
            result[fsf] = idx;
            return result;
        } else {
            int[] result = solve(array, idx + 1, data, fsf);
            return result;
        }
    }
}
