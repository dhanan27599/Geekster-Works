package Stack_Questions;

import FastScanner.FastScanner;

import java.util.*;
import java.io.IOException;

public class DirectoryStructure {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        String directory = fs.nextLine();
        System.out.println(solve(directory));
    }

    private static String solve(String directory) {
        Stack<String> stack = new Stack<>();
        String[] strarray = directory.split("/");
        StringBuilder sb = new StringBuilder();
        for (String s : strarray) {
            if (s.equals("..")) {
                stack.pop();
            } else if (!s.equals("")) {
                stack.push(s);
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append("/");
        }
        return sb.reverse().toString();
    }
}
