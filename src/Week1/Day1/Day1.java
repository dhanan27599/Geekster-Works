package Week1.Day1;

import java.util.*;

public class Day1 {
    public static void main(String[] args) {

        reverse(1142);

        int a = 4, b = 2, c = 3;

        if(a > b && a > c) {
            System.out.println(a);
        } else if(b > c){
            System.out.println(b);
        } else {
            System.out.println(c);
        }
//
////        int a = 4, b = 5, c = 3;
////
////        System.out.println(a > b ? a > c ? a : c : b);
//
        Scanner sc = new Scanner(System.in);
//
        int celsius = sc.nextInt();
        double farenheit = (9 * (double)celsius / 5) + 32;
        System.out.println(farenheit);
//
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 1 ; i <= n ; i++){
            sum += i;
//            System.out.println(sum);
        }
        System.out.println(sum);
//
////        System.out.println((n * (n + 1))/2);
//
        int in = sc.nextInt();
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < in ; i++) {
            int val = sc.nextInt();
            if(val > max){
                max = val;
            }
        }
        System.out.println(max);

//        int value = sc.nextInt();
//        boolean state = true;
//        for(int i = 2 ; i <= value / 2 ; i++) {
//            if(value % i == 0) {
//                state = false;
//                break;
//            }
//        }
//
//        System.out.println(state ? "Prime Number" : "Composite Number");

        int value = sc.nextInt();
        boolean state = true;
        for(int i = 2 ; i <= Math.sqrt(value) ; i++) {
            if(value % i == 0) {
                state = false;
                break;
            }
        }

        System.out.println(state ? "Prime Number" : "Composite Number");

        count(110);
        count(1111010101);

    }

    public static void count(int val) {
        int count = 0;

        while(val != 0) {
            count += 1;
            val /= 10;
        }

        System.out.println(count);
    }

    public static void reverse(int val) {
        int rev = 0;
        while(val != 0) {
            int rem = val % 10;
            rev = rev * 10 + rem;
            val /= 10;
        }

        System.out.println(rev);
    }
}
