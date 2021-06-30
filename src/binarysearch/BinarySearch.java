package binarysearch;
import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 7, 9, 13, 17, 22);
//        System.out.println(Collections.binarySearch(list, 12));
        System.out.println(lowerBound(list, 7));
    }

    public static int lowerBound(List<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return -1;

        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left)/ 2;
            if (list.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }

        return list.get(left) >= target ? left : -1;
    }

    public static int upperBound(List<Integer> list, int target) {
        if (list == null || list.size() == 0) {
            return -1;
        }

        int left = 0;
        int right = list.size() - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return list.get(left) > target ? left : -1;
    }

}
