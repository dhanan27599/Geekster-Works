package PriorityQueue_Ques.Heap_Implementation;

import java.util.ArrayList;

public class MinHeap extends Heap{
    public MinHeap() {
        heap = new ArrayList<>();
        size = 0;
    }

    public MinHeap(int[] arr) {
        heap = new ArrayList<>();
        size = 0;
        for(int i : arr) {
            add(i);
        }
    }
    @Override
    public void add(int val) {
        // Add it in the last of the list and heapify up
        heap.add(val);
        heapifyup(heap.size() - 1);
    }
    @Override
    public void heapifyup(int idx) {
        // swap it with the parent until the condition get satisfied
        while(heap.get(parentIndex(idx)) > heap.get(idx)) {
            swap(parentIndex(idx), idx);
            idx = parentIndex(idx);
        }
    }
    @Override
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

    @Override
    public void heapifydown(int idx) {
        int left = leftIndex(idx);
        int right = rightIndex(idx);

        int lastIdx = heap.size() - 1;
        int childIdx = 0;
        while(left <= lastIdx) {
            if(left == lastIdx) {                           // If Left Index is the Only Child
                childIdx = left;
            } else if(heap.get(left) < heap.get(right)) {   // If Left Index is Smaller than Right Index
                childIdx = left;
            } else {                                        // If Left Index is Greater than Right Index
                childIdx = right;
            }

            if(heap.get(idx) > heap.get(childIdx)) {        // Compare with Current Index
                swap(idx, childIdx);
                idx = childIdx;                             // Change Index with the child Index
                left = leftIndex(idx);
                right = rightIndex(idx);
            } else {
                return;
            }
        }
    }
}
