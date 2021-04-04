package Stack_Questions;

import FastScanner.FastScanner;
import java.util.*;
import java.io.IOException;

public class Largest_Rectangular_Area_Of_Histogram {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] array = fs.nextIntArray(n);
        int result =solve(array);
        System.out.println(result);
    }

    public static int solve(int[] array) {
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        int maxarea = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        left[0] = -1;
        for(int i = 1 ; i < array.length ; i++) {
            while(stack.size() > 0 && array[i] < array[stack.peek()]) {
                stack.pop();
            }

            if(stack.size() != 0) {
                left[i] = stack.peek();
            } else {
                left[i] = -1;
            }
            stack.push(i);
        }

        stack = new Stack<>();
        stack.push(array.length - 1);
        right[array.length - 1] = array.length;
        for(int i = array.length - 2 ; i >=  0 ; i--) {
            while(stack.size() > 0 && array[i] < array[stack.peek()]) {
                stack.pop();
            }

            if(stack.size() != 0) {
                right[i] = stack.peek();
            } else {
                left[i] = array.length;
            }
            stack.push(i);
        }

        for (int i = 0; i < array.length; i++) {
            int area = array[i] * (right[i] - left[i] - 1);
            maxarea = Math.max(maxarea, area);
        }

        return maxarea;
    }
}
