package Stack_Questions;

import java.io.IOException;
import java.util.Stack;

import FastScanner.FastScanner;

public class NextGreaterElement {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int size = fs.nextInt();
        int[] array = fs.nextIntArray(size);
        solve(array);
    }

    public static void solve(int[] array) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < array.length ; i++) {
            int val = array[i];
            while(!stack.isEmpty() && stack.peek() < val) {
                int temp = stack.pop();
                System.out.println(temp + "--->" + val);
            }
            stack.push(val);
        }

        while(!stack.isEmpty()) {
            int temp = stack.pop();
            System.out.println(temp + "--->" + "-1");
        }
    }
}
