package Stack_Questions;

import FastScanner.FastScanner;

import java.io.IOException;
import java.util.*;

public class RemoveAdjacentDuplicate {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] arr = fs.nextIntArray(n);
        solve(arr);
    }

    public static void solve(int[] arr) {
        Stack<Integer> stack = new Stack<>();
//        List<Integer> list = new ArrayList<>();

        for(Integer i : arr) {
            if(!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
            } else {
                stack.push(i);
            }
        }

        System.out.println(stack.toString());
    }
}
