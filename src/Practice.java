import java.math.*;
import java.text.*;
import java.util.*;

public class Practice {
    public static void main(String[] args) {
//        String s = "Hello? World!";
//        StringBuilder sb = new StringBuilder();
//        for(char c : s.toCharArray()) {
//            if(Character.isAlphabetic(c) || Character.isSpaceChar(c)) {
//                sb.append(c);
//            }
//        }
//        s = sb.toString();
//        System.out.println(s);
//        String[] str = sb.toString().split(" ");
//        for(int i = str.length - 1 ; i >= 0 ; i--) {
//            System.out.print(str[i] + " ");
//        }
//        Scanner scanner = new Scanner(System.in);
//        double payment = scanner.nextDouble();
//        scanner.close();

//        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
//        String india = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
//        System.out.println("US: " + us);
//        System.out.println("India: " + india);

//        BitSet b1 = new BitSet();
//        boolean flag = true;
//        for(int i = 1 ; i <= 16 ; i++) {
//            b1.set(i, flag);
//            flag = !flag;
//        }
//        flag = false;
//        BitSet b2 = new BitSet();
//        for(int i = 1 ; i <= 16 ; i++) {
//            b2.set(i, flag);
//            flag = !flag;
//        }
//        b1.xor(b2);
//        System.out.println(b2);

//        print(1);
//        print("bit");
//        print(4.72);
//        print('h');

//        Scanner in = new Scanner(System.in);
//        ArrayList<pair> arr = new ArrayList<pair>();
//        int n = in.nextInt();
//        in.nextLine();
//        for(int i = 0;i<n;i++)
//        {
//            int a = in.nextInt();
//            int b = in.nextInt();
//            arr.add(new pair(a,b));
//            in.nextLine();
//        }
//        in.close();
//        Collections.sort(arr, new mysort());
//        for(int i=0;i<n;i++)
//        {
//            System.out.println(arr.get(i).first + " " + arr.get(i).second);
//        }


//        int[] result = maxset(new int[] {-1, -1, -1, -1, -1});
//
//        for(int i : result) {
//            System.out.print(i + " ");
//        }

//        System.out.println(longFact(2));

//        System.out.println(maximumGap(new int[]{3, 5, 4, 2}));

//        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
//        ArrayList<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(4);
//        list2.add(5);
//        list2.add(6);
//        ArrayList<Integer> list3 = new ArrayList<>();
//        list3.add(7);
//        list3.add(8);
//        list3.add(9);
//        mat.add(list1);
//        mat.add(list2);
//        mat.add(list3);
//
//        System.out.println(diagonal(mat));

//        TreeSet<Integer> set = new TreeSet<>();
//        set.add(7);
//        System.out.println(set.lower(8));



    }

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list= new ArrayList<>();
        list.add(arr.get(0).get(0));
        result.add(list);

        for(int j = 1 ; j < arr.size() ; j++) {
            list = new ArrayList<>();
            int i = 0;
            int k = j;
            while(k >= 0) {
                list.add(arr.get(i).get(k));
                k--;
                i++;
            }
            result.add(list);
        }

        for(int i = 1 ; i < arr.size() - 1 ; i++) {
            list = new ArrayList<>();
            int j = i;
            int k = arr.size() - 1;
            while(j <= arr.size() - 1) {
                list.add(arr.get(j).get(k));
                j++;
                k--;
            }
            result.add(list);
        }
        list = new ArrayList<>();
        list.add(arr.get(arr.size() - 1).get(arr.size() - 1));
        result.add(list);
        return result;
    }

    public static String longFact(int n) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= n; i++)
            f = f.multiply(BigInteger.valueOf(i));
        return f.toString();
    }

    public static int[] maxset(int[] arr) {
        int left = 0;
        int idx = 0;
        int right = 0;
        int size = 0;
        int sum = 0;
        int maxsum = 0;
        int maxsize = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] > 0) {
                sum += arr[i];
                size += 1;
                if(sum > maxsum) {
                    maxsum = sum;
                    left = idx;
                    right = i;
                    maxsize = size;
                }
            } else {
                sum = 0;
                idx = i + 1;
                size = 0;
            }
        }
        int[] result = new int[maxsize];

        int k = 0;
        for(int i = left ; i <= right && left != right  ; i++) {
            result[k++] = arr[i];
        }

        return result;
    }

//    public static int[] spiralOrder(final int[][] matrix) {
//        int[] result = new int[matrix.length * matrix[0].length];
//        int k = 0;
//
//        int left = 0;
//        int right = matrix[0].length - 1;
//        int top = 0;
//        int bottom = matrix[0].length - 1;
//
//        while(k < result.length) {
//
//            for(int i = left ; i <= right && k < result.length ; i++) {
//                result[k++] = matrix[top][i];
//            }
//            top += 1;
//
//            for(int i = top ; i <= bottom && k < result.length ; i++) {
//                result[k++] = matrix[i][right];
//            }
//            right -= 1;
//
//            for(int i = right ; i >= left && k < result.length ; i--) {
//                result[k++] = matrix[bottom][i];
//            }
//            bottom -= 1;
//
//            for(int i = bottom ; i >= top && k < result.length ; i--) {
//                result[k++] = matrix[i][left];
//            }
//            left += 1;
//        }
//
//        return result;
//    }

//    public static <T> void print(T elem) {
//        System.out.println(elem.toString());
//    }

    public static int maximumGap(final int[] arr) {
        Helper[] harr = new Helper[arr.length];
        for(int i = 0 ; i < arr.length ; i++) {
            harr[i] = new Helper(arr[i], i);
        }

        Arrays.sort(harr);

        int[] rightmax = new int[arr.length];
        int maxval = Integer.MIN_VALUE;
        for(int i = arr.length - 1 ; i >= 0 ; i--) {
            maxval = Math.max(maxval, harr[i].index);
            rightmax[i] = maxval;
        }

        int maxdiff = Integer.MIN_VALUE;

        for(int i = 0 ; i < arr.length ; i++) {
            maxdiff = Math.max(maxdiff, rightmax[i] - harr[i].index);
        }

        return maxdiff;
    }
}

class mysort implements Comparator<pair> {
    @Override
    public int compare(pair a, pair b) {
        if(a.second == b.second) {
            return a.first - b.first;
        } else {
            return a.second - b.second;
        }
    }
}

class pair implements Comparable<pair>{
    int first;
    int second;

    public pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(pair o) {
        if(this.second == o.second) {
            return o.first - this.first;
        } else {
            return o.second - this.second;
        }
    }
}

class Helper implements Comparable<Helper> {
    public int value;
    public int index;

    public Helper(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Helper helper) {
        // Comparison on the value

        if (value < helper.value) {
            return -1;
        } else if (value == helper.value) {
            return 0;
        } else {
            return 1;
        }
    }
}

