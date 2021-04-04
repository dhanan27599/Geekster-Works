package PriorityQueue_Ques;
import java.util.*;
public class MedianPriorityQueue {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });

    public MedianPriorityQueue() {}

    public MedianPriorityQueue(int[] arr) {
        for(int i : arr) {
            add(i);
        }
    }

    public void add(int val) {
        if(max.size() == 0 && min.size() == 0) {
            max.add(val);
        } else if(max.size() == 0) {
            max.add(val);
        } else if(min.size() == 0){
            min.add(val);
        } else {
            if(val < max.peek()) {
                max.add(val);
            } else {
                min.add(val);
            }
            balance(max, min);
        }
    }

    private void balance(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        if(max.size() - min.size() > 1) {
            min.add(max.remove());
        } else if (min.size() - max.size() > 1) {
            max.add(min.remove());
        }
    }

    public int median() {
        return max.size() >= min.size() ? max.peek() : min.peek();
    }

    public int size() {
        return max.size() + min.size();
    }

    public int remove() {
        int ret;
        if(max.size() >= min.size()) {
            ret = max.remove();
        } else {
            ret = min.remove();
        }
        return ret;
    }

}

class Main {
    public static void main(String[] args) {
        int[] arr = {10, 100, 90, 80, 110, 105, 120};
        MedianPriorityQueue mp = new MedianPriorityQueue(arr);
        System.out.println(mp.median());
        System.out.println();
        System.out.println(mp.remove());
        System.out.println(mp.remove());
        System.out.println(mp.remove());
        System.out.println(mp.remove());
    }
}
