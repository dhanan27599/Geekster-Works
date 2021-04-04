import java.io.*;
import java.util.stream.*;

class Node {
    public int data;
    public Node next;

    public Node(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public Node head;
    public Node tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        Node node = new Node(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST List
     *  2. INTEGER N
     */

    // * For your reference:
    // *
    // * Node {
    // *     int data;
    // *     Node next;
    // * }
    // *


    public static Node reverseKGroups(Node head, int k) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node current = dummy;

        while(current.next != null) {
            //* Create a start Node and end Node for K seperation :)
            Node start = current.next;
            Node end = current.next;
            int i = 1;
            while(end != null && i++ < k) {
                end = end.next;
            }

            if(end == null) {  //! If end is null, then we don't need to reverse the part :(
                break;
            }

            //! Storing the "Next to End" node in a next variable and break the List (end.next = null) :()
            Node next = end.next;
            end.next = null;

            //* Process of Reversing

            Node temp = start;
            Node prev = null;
            while(temp != null) {
                Node nextNode = temp.next;
                temp.next = prev;
                prev = temp;
                temp = nextNode;
            }

            current.next = end;         //! Linking with the current node
            start.next = next;          //! Joining the Breaked list
            current = start;            //! For the next iteration
        }
        return dummy.next;
    }

    public static Node reverseKGroupsRecursive(Node head, int k) {
        if(head == null) {
            return head;
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        Node current = dummy;

        if(current.next != null) {
            Node start = current.next;
            Node end = current.next;
            int i = 1;
            while(end != null && i++ < k) {
                end = end.next;
            }

            if(end == null) {
                return start;
            }

            Node next = reverseKGroupsRecursive(end.next, k);
            end.next = null;

            Node temp = start;
            Node pre = null;
            while(temp != null) {
                Node nextNode = temp.next;
                temp.next = pre;
                pre = temp;
                temp = nextNode;
            }

            current.next = end;
            start.next = next;

            current = start;
        }

        return dummy.next;
    }

    public static Node rotateKGroups(Node head, int k) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node current = dummy;

        while(current.next != null) {
            //* Create a start Node and end Node for K seperation :)
            Node start = current.next;
            Node end = current.next;
            int i = 1;
            while(end != null && i++ < k) {
                end = end.next;
            }

            if(end == null) {  //! If end is null, then we don't need to reverse the part :(
                break;
            }

            //! Storing the "Next to End" node in a next variable and break the List (end.next = null) :()
            Node next = end.next;
            end.next = null;

            //* Process of Rotating
            Node temp = start;
            while(start.next != end) {
                start = start.next;
            }

            end.next = temp;
            start.next = next;          //! Joining the Breaking List

            current.next = end;         //! Linking with the current node
            current = start;            //! For the next iteration
        }
        return dummy.next;
    }

    public static Node rotateKGroupsRecursive(Node head, int k) {
        if(head == null) {
            return head;
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        Node current = dummy;

        if(current.next != null) {
            //* Create a start Node and end Node for K seperation :)
            Node start = current.next;
            Node end = current.next;
            int i = 1;
            while(end != null && i++ < k) {
                end = end.next;
            }

            if(end == null) {  //! If end is null, then we don't need to reverse the part :(
                return null;
            }

            //! Storing the "Next to End" node in a next variable and break the List (end.next = null) :()
            Node next = rotateKGroupsRecursive(end.next, k);
            end.next = null;

            //* Process of Rotating
            Node temp = start;
            while(start.next != end) {
                start = start.next;
            }

            end.next = temp;
            start.next = next;          //! Joining the Breaking List

            current.next = end;         //! Linking with the current node
            current = start;            //! For the next iteration
        }
        return dummy.next;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        SinglyLinkedList l = new SinglyLinkedList();

        int lCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, lCount).forEach(i -> {
            try {
                int lItem = Integer.parseInt(bufferedReader.readLine().trim());

                l.insertNode(lItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Node result = Result.rotateKGroups(l.head, n);

        while(result != null) {
            System.out.println(result.data);
            result = result.next;
        }

        bufferedReader.close();
    }
}
