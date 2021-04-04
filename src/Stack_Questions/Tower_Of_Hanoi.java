package Stack_Questions;

import java.util.*;

public class Tower_Of_Hanoi {
    public static void main(String[] args) {
        solve(3);
    }

    public static void solve(int n) {
        solve(n, 'A', 'B', 'C');
    }

    private static void solve(int n, char source, char destination, char helper) {
        if(n != 0) {
            solve(n - 1, source, helper, destination);
            System.out.println("Move "+ n + "th disk from " + source + " to " + destination);
            solve(n - 1, helper, destination, source);
        }
    }
}
