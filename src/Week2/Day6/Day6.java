package Week2.Day6;
import java.util.*;
public class Day6 {
    public static void main(String[] args) {
//        uniqueoccurence();
//        missingnumber();
//        painterpartition();
//        printWave();
//        printSpiral();
    }

    private static void printSpiral() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int startRow = 0;
        int endRow = arr.length - 1;
        int startCol = 0;
        int endCol = arr[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                System.out.println(arr[startRow][i]);
            }
            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                System.out.println(arr[i][endCol]);
            }
            endCol--;

            for (int i = endCol; i >= startCol; i--) {
                System.out.println(arr[endRow][i]);
            }
            endRow--;

            for (int i = endRow; i >= startRow; i--) {
                System.out.println(arr[i][startCol]);
            }
            startCol++;
        }
    }

    public static void printWave() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        boolean flag = false;
        for (int j = 0; j < arr[0].length; j++) {
            if (flag == false) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int i = arr.length - 1; i >= 0; i--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            flag = !flag;
            System.out.println();
        }
    }

    private static void painterpartition() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        int k = sc.nextInt();

        for(int i = 0 ; i < size ; i++) {
            array[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i : array) {
            sum += i;
            max = Math.max(max, i);
        }

        int low = max;
        int high = sum;

        while(low < high) {
            int mid = (low + high) / 2;
            int pr = calc(array, mid);
            if(pr <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }

    private static int calc(int[] nums, int time) {
        int count = 1;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            if(sum > time) {
                sum = nums[i];
                count += 1;
            }
        }
        return count;
    }

    private static void missingnumber() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];

        for(int i = 0 ; i < size ; i++) {
            array[i] = sc.nextInt();
        }

        for(int i = 0 ; i < size ; i++) {
            if(array[Math.abs(array[i]) - 1] > 0) {
                array[Math.abs(array[i]) - 1] *= -1;
            }
        }

        for(int i = 0 ; i < size ; i++) {
            if(array[i] > 0) {
                System.out.println(i + 1);
                break;
            }
        }
        sc.close();
    }

    public static void uniqueoccurence() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size ; i++) {
            array[i] = sc.nextInt();
        }
        int result = array[0];
        for(int i = 1; i < size ; i++) {
            result ^= array[i];
        }
        System.out.println(result);
        sc.close();
    }
}
