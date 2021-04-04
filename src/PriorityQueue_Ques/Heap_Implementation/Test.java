package PriorityQueue_Ques.Heap_Implementation;

public class Test {
    public static void main(String[] args) {
        Heap heap = new MaxHeap();
        heap.add(3);
        heap.add(2);
        heap.add(1);
//        System.out.println(heap.size());
        while(heap.size() != 0) {
            System.out.println(heap.remove());
        }
    }
}
