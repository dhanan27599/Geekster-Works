package PriorityQueue_Ques.Heap_Implementation;
import java.util.*;
public class Heap {
    ArrayList<Integer> heap;
    int size;

    public Heap() {
    }

    public void add(int val) {
        // Add it in the last of the list and heapify up
        heap.add(val);
        heapifyup(heap.size() - 1);
    }

    public void heapifyup(int idx) { }

    public int remove() {
        // Heap Underflow
        if(heap.size() == 0) {
            System.out.println("Heap Underflow");
            return -1;
        }

        int peak = heap.get(0);
        int lastIdx = heap.size() - 1;

        // Set the Last Value in the 0th Index and remove the last value of the list
        heap.set(0, heap.get(lastIdx));
        heap.remove(lastIdx);

        heapifydown(0);

        return peak;
    }

    public void heapifydown(int idx) { }

    public int leftIndex(int idx) {
        return 2 * idx + 1;
    }

    public int rightIndex(int idx) {
        return 2 * idx + 2;
    }

    public void swap(int idx1, int idx2) {
        int temp = heap.get(idx1);
        heap.set(idx1, heap.get(idx2));
        heap.set(idx2, temp);
    }

    public int parentIndex(int idx) {
        return (idx - 1) / 2;
    }

    public int peek() {
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

}
