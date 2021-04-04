package Dynamic_Programming;

public class Binary_String_No_2Adj {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(solve(n));
    }

    public static int solve(int n) {
        int zeroinc = 1;
        int oneinc = 1;

        for(int i = 2 ; i <= n ; i++) {
            int prevone = oneinc;
            int prevzero = zeroinc;
            zeroinc = prevone;
            oneinc = prevone + prevzero;
        }

        return zeroinc + oneinc;
    }
}
