package Queue_Questions;

import java.util.Arrays;

public class DynamicQueue extends QueueList {
    public DynamicQueue(int cap) {
        super(cap);
    }

    @Override
    public void enqueue(int val) throws Exception{
        if(size == arr.length) {
            int[] oldarr = arr;
            arr = new int[oldarr.length * 2];
            arr = Arrays.copyOfRange(oldarr, 0, arr.length);
            front = 0;
            rear = size - 1;
        }
        rear += 1;
        rear %= arr.length;
        arr[rear] = val;
        if(front == -1) {
            front = 0;
        }
        size += 1;
    }
}
