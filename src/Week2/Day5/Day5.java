package Week2.Day5;

import java.util.*;

public class Day5 {
    // Arrays & Algorithms


    public static void main(String[] args) {
//        waterandwall();
//        mergelist();
//        majorityelement();
        // System.out.println(waterwall(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static void majorityelement() {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] nums = new int[size];

        for(int i = 0 ; i < size ; i++) {
            nums[i] = sc.nextInt();
        }

        int majority = nums[0];
        int count = 1;
        int n = nums.length;
        for(int j = 1 ; j < n ; j++) {
            int i = nums[j];
            if(majority == i) {
                count++;
            } else {
                --count;
                if(count == 0) {
                    majority = i;
                    count = 1;
                }
            }
        }
        count = 0;

        for(int i : nums) {
            if(majority == i) {
                count += 1;
            }
        }

        if(count > (n/2)) {
            System.out.println(majority);
        } else {
            System.out.println("No Majority Vote");
        }

        sc.close();
    }

    private static void mergelist() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(6);
        list1.add(18);

        list2.add(1);
        list2.add(4);
        list2.add(4);
        list2.add(8);
        list2.add(12);
        list2.add(65);


//        Collections.sort(list1);
//        Collections.sort(list2);

        int i = 0, j = 0;

        while(i < list1.size() && j < list2.size()) {
            if(list1.get(i) < list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }
        while(i < list1.size()) {
            result.add(list1.get(i++));
        }
        while(j < list2.size()) {
            result.add(list2.get(j++));
        }

        System.out.println(result);
    }

    private static void waterandwall() {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt(); // 12
        int[] wall = new int[size]; // 0 1 0 2 1 0 1 3 2 1 2 1
        for(int i = 0 ; i < size ; i++) {
            wall[i] = sc.nextInt();
        }

        int[] leftmax = new int[size];
        int[] rightmax = new int[size];

        leftmax[0] = wall[0];
        rightmax[size - 1] = wall[size - 1];

        for(int i = 1 ; i < size ; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], wall[i]);
        }

        for(int i = size - 2 ; i >= 0 ; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], wall[i]);
        }

        int result = 0;

        for(int i = 0 ; i < size ; i++) {
            int min = Math.min(leftmax[i], rightmax[i]);

            if(min > wall[i]) {
                result += min - wall[i];
            }

        }

        System.out.println(result); // 6

        sc.close();
    }

    // public static int waterwall(int[] height) {
    //     int maxarea = 0, l = 0, r = height.length - 1;
    //     while (l < r) {
    //         maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
    //         if (height[l] < height[r])
    //             l++;
    //         else
    //             r--;
    //     }
    //     return maxarea;
    // }
}
