package Queue_Questions;

import java.util.*;

public class QueueList {
    // Using ArrayList
//    List<Integer> list;
//
//    public QueueList() {
//        list = new ArrayList<>();
//    }
//
//    public void enqueue(int val) {
//        list.add(val);
//    }
//
//    public int dequeue() {
//        return list.remove(0);
//    }
//
//    public int removeLast() {
//        return list.remove(list.size() - 1);
//    }
//
//    public int size() {
//        return list.size();
//    }
//
//    public boolean isEmpty() {
//        return list.isEmpty();
//    }
    // Creating Real Type of Queue
    
    int[] arr;
    int front;
    int rear;
    int size;
//    private int rear;
    public QueueList() {
        front = -1;
        rear = -1;
        arr = new int[5];
    }

    public QueueList(int cap) {
        front = -1;
        rear = -1;
        arr = new int[cap];
    }

    public void enqueue(int val) throws Exception{
        if(size == arr.length) {
            throw new Exception("Queue Is Full");
        }
        rear += 1;
        rear %= arr.length;
        if(front == -1) {
            front += 1;
        }
        arr[rear] = val;
        size += 1;
    }

    public int dequeue() throws Exception{
        if(size == 0) {
            throw new Exception("Empty Queue");
        }
        int temp = arr[front];
        front += 1;
        front %= arr.length;
        size -= 1;
        return temp;
    }

    public int front() throws Exception{
        if(size == 0) {
            throw new Exception("Empty Queue");
        } else {
            return arr[front];
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        for(int i = 0 ; i < size ; i++) {
            System.out.print(arr[(i + front) % arr.length] + " ");
        }
        System.out.println();
    }
}
