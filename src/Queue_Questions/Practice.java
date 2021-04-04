package Queue_Questions;

public class Practice {
    public static void main(String[] args) throws Exception {
//        QueueList queue = new DynamicQueue(3);
//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);
//        queue.enqueue(40);
//        queue.enqueue(50);
//        queue.display();

        TwoStacks stacks = new TwoStacks(10);
        stacks.push1(1);
        stacks.push1(2);
        stacks.push1(3);
        stacks.push2(1);
        stacks.push2(2);
        stacks.push2(3);
//        stacks.pop1();
//        stacks.pop2();
        stacks.display();
    }
}
