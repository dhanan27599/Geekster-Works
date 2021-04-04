package Queue_Questions;

public class TwoStacks {
    int[] arr;
    int top1;
    int top2;
    int size;


    public TwoStacks(int cap) {
        arr = new int[cap];
        top1 = arr.length / 2 - 1;
        top2 = arr.length / 2;
        size = 0;
    }

    public void push1(int val) throws Exception{
        if(top1 != 0) {
            arr[top1] = val;
            top1 -= 1;
            size += 1;
        } else {
            throw new Exception("Size Overflow");
        }
    }

    public void push2(int val) throws Exception{
        if(top2 != arr.length) {
            arr[top2] = val;
            top2 += 1;
            size += 1;
        } else {
            throw new Exception("Size Overflow");
        }
    }

    public int pop1() throws Exception{
        if(top1 != arr.length / 2) {
            top1 += 1;
            int temp = arr[top1];
            arr[top1] = 0;
//            top1 += 1;
            size -= 1;
            return temp;
        } else {
            throw new Exception("Underflow");
        }
    }

    public int pop2() throws Exception{
        if(top2 != arr.length) {
            top2 -= 1;
            int temp = arr[top2];
            arr[top2] = 0;
//            top2 -= 1;
            size -= 1;
            return temp;
        } else {
            throw new Exception("Underflow");
        }
    }

    public void display() {
        for(int i = top1 + 1 ; i < top2 ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
