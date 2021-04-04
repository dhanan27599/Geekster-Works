package Stack_Questions;

import FastScanner.FastScanner;
import java.util.*;
import java.io.IOException;

public class StockSpan {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] stock = fs.nextIntArray(n);
        int[] result = solve(stock);

        for(int i : result) {
            System.out.print(i + " ");
        }

    }

    public static int[] solve(int[] stock) {
        int[] result = new int[stock.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        result[0] = 1;
        for(int i = 1 ; i < stock.length ; i++) {
            while(stack.size() > 0 && stock[i] > stock[stack.peek()]){
                stack.pop();
            }
            if(stack.size() == 0) {
                result[i] = i + 1;
            } else {
                result[i] = i - stack.peek();
            }
            stack.push(i);
        }

        return result;
    }
}
