package Week1.Day2;

import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Val: ");
        int val = sc.nextInt();
//        pattern1(val);
//        pattern2(val);
//        pattern3(val);
//        pattern4(val);
//        pattern5(val);
//        pattern6(val);
        pattern7(val);
    }


    private static void pattern1(int val) {
        int row = 1;
        int cst = 1;
        int nst = 1;
        while(row <= val) {
            cst = 1;
            while(cst <= nst) {
                System.out.print("*");
                cst++;
            }
            System.out.println();
            nst++;
            row++;
        }
    }

    private static void pattern2(int val) {
        int row = 1;
        int cst = 1;
        int nst = 1;
        while(row <= val) {
            cst = 1;
            while(cst <= nst) {
                System.out.print(cst);
                cst++;
            }
            System.out.println();
            nst++;
            row++;
        }
    }

    private static void pattern3(int val) {
        int row = 1;
        int cst = 1;
        int nst = 1;
        int print = 1;
        while(row <= val) {
            cst = 1;
            while(cst <= nst) {
                System.out.print(print++);
                cst++;
            }
            System.out.println();
            nst++;
            row++;
        }
    }
    private static void pattern4(int val) {
        int row = 1;
        int nst = 1;
        int nsp = val - 1;
        while(row <= val) {
            int csp = 1;
            int cst = 1;
            while(csp++ <= nsp) {
                System.out.print(" ");

            }
            while(cst++ <= nst) {
                System.out.print("*");

            }
            nsp--;
            nst++;
            System.out.println();
            row++;
        }
    }

    private static void pattern5(int val) {
        int row = 1;
        int nst = 1;
        int nsp = val - 1;
        while(row <= val) {
            int csp1 = 1;
            int csp2 = 1;
            int cst = 1;
            while(csp1++ <= nsp) {
                System.out.print(" ");
            }
            while(cst++ <= nst) {
                System.out.print("*");
            }
            while(csp2++ <= nsp) {
                System.out.print(" ");
            }

            nsp--;
            nst += 2;
            System.out.println();
            row++;
        }
    }

    private static void pattern6(int val) {
        int row = 1;
        int nst = 1;
        int nsp = val - 1;

        while(row <= (2*val)-1) {
            int csp1 = 1;
            int csp2 = 1;
            int cst = 1;
            while(csp1++ <= nsp) {
                System.out.print(" ");
            }
            while(cst++ <= nst) {
                System.out.print("*");
            }
            while(csp2++ <= nsp) {
                System.out.print(" ");
            }
            if(row < val) {
                nsp--;
                nst += 2;
            } else {
                nsp++;
                nst -= 2;
            }
            System.out.println();
            row++;
        }
    }

    private static void pattern7(int val) {
        int row = 1;
        int cst = 1;
        int nst = 1;
        int count = 1;
        int print = 1;
        while(row <= val) {
            cst = 1;
            while(cst <= nst) {
                System.out.print(print--);
                cst++;
            }
            System.out.println();
            nst++;
            ++row;
            print = print + row + count++;
        }
    }

}
