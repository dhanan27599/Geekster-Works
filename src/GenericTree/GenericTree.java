package GenericTree;

import java.util.*;

public class GenericTree {


    class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data) {
            this.data = data;
        }
        @Override
        public String toString() {
            return this.data + children.toString();
        }
    }

    private Node root;
    private int size;

    // Insert Through Array
    public GenericTree(int[] arr) {
        Stack<Node> stack = new Stack<>();

        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == -1) {
                stack.pop();
            } else {
                Node node = new Node(arr[i]);
                this.size += 1;
                if(stack.size() > 0) {
                    stack.peek().children.add(node);
                } else {
                    root = node;
                }
                stack.push(node);
            }
        }

     }

     // Function for Size
     public int size() {
        if(root == null) {
            return 0;
        }
        return size(root);
     }

     private int size(Node root) {
        int size = 1;
        for(Node child : root.children) {
            int child_size = size(child);
            size += child_size;
        }
        return size;
    }

    // Function for Max_Value
    public int max() {
        if(root == null) {
            return -1;
        }
        return max(root);
    }

    private int max(Node root) {
        int max = root.data;
        for(Node child : root.children) {
            int max_val = max(child);
            max = Math.max(max, max_val);
        }
        return max;
    }

    //Function for Max_Height
     public int height() {
        return height(root);
     }

    private int height(Node root) {
        int height = 0;
        for(Node child : root.children) {
            int child_height = height(child);
            height = Math.max(height, child_height);
        }
        height += 1;
        return height;
    }

    // Function for Finding a value
    public boolean find(int data) {
        return find(root, data);
     }

    private boolean find(Node root, int data) {
        if(root.data == data) {
            return true;
        }
        for(Node child : root.children) {
            boolean child_result = find(child, data);
            if(child_result) {
                return true;
            }
        }
        return false;
    }

    // Return the Path from Data to Root
    public ArrayList<Integer> nodeToRootPath(int data) {
         return nodeToRootPath(root, data);
    }

    private ArrayList<Integer> nodeToRootPath(Node root, int data) {
        if(root.data == data) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(root.data);
            return res;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(Node child : root.children) {
            ArrayList<Integer> child_result = nodeToRootPath(child, data);
                if(child_result.size() > 0) {
                    result = child_result;
                    result.add(root.data);
                    return result;
                }
            }
        return new ArrayList<>();
    }

    // Remove Leaves from Tree
    public void removeLeaves() {
        removeLeaves(this.root);
    }

    private void removeLeaves(Node root) {
        for(int i = root.children.size() - 1 ; i >= 0  ; i--) {
            Node child = root.children.get(i);
            if(child.children.size() > 0) {
                removeLeaves(child);
            } else {
                root.children.remove(child);
            }
        }
    }

    //Shift to Mirror
    public void mirror() {
        mirror(root);
    }

    private void mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }

        int l = 0;
        int r = node.children.size() - 1;
        while (l < r) {
            Node leftNode = node.children.get(l);
            Node rightNode = node.children.get(r);
            node.children.set(l, rightNode);
            node.children.set(r, leftNode);
            l++;
            r--;
        }
    }


    /**
    public ArrayList<Integer> linearized() {
        return linearized(root);
    }

    private ArrayList<Integer> linearized(Node root) {
        if(root.children.size() == 0) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(root.data);
            return res;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(Node child : root.children) {
            ArrayList<Integer> child_list = linearized(child);
            for(Integer i : child_list) {
                result.add(i);
            }
        }
        result.add(0, root.data);
        return result;
    }
    */

    // Print in Preorder of Root
    public void linearise() {
        linearise(root);
    }

    private void linearise(Node node) {
        for (Node child : node.children) {
            linearise(child);
        }

        for (int i = node.children.size() - 1; i > 0; i--) {
            Node last = node.children.remove(i);
            Node slast = node.children.get(i - 1);
            Node sltail = getTail(slast);
            sltail.children.add(last);
        }
    }

    private Node getTail(Node node) {
        Node tail = node;
        while (tail.children.size() != 0) {
            tail = tail.children.get(0);
        }

        return tail;
    }

    public void linearise2() {
        linearise2(root);
    }

    private Node linearise2(Node node) {

        if(node.children.size()==0){
            return node;
        }

        Node ltail = linearise2(node.children.get(node.children.size() - 1));
        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node sltail = linearise2(sl);
            sltail.children.add(last);
        }

        return ltail;
    }

    public static boolean areSimilarShaped(GenericTree gt1, GenericTree gt2){
        return areSimilarShaped(gt1.root, gt2.root);
    }

    private static boolean areSimilarShaped(Node n1,Node n2){
        if(n1.children.size()!=n2.children.size()){
            return false;
        }

        for(int i=0;i<n1.children.size();i++){
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            boolean acss = areSimilarShaped(c1, c2);
            if(acss == false){
                return false;
            }
        }

        return true;
    }

    public static boolean isSymmetric(GenericTree t1, GenericTree t2) {
        return isSymmetrical(t1.root, t2.root);
    }

    public static boolean isSymmetrical(Node node1, Node node2) {
        if(node1 == null && node2 == null) {
            return true;
        }

        if(node2 == null || node1 == null) {
            return false;
        }

        if(node1.children.size() != node2.children.size()) {
            return false;
        }

        int i = 0;
        int j = node2.children.size() - 1;
        if(node1.data == node2.data) {
            while(i < node1.children.size() && j >= 0) {
                if(!isSymmetrical(node1.children.get(i), node2.children.get(j))) {
//                    return false;
                    break;
                }
                i++;
                j--;
            }
        }
        if(i < node1.children.size() || j >= 0) {
            return false;
        }
        return true;
    }

    public static int odd_even_level_sum(GenericTree t) {
        return odd_even_level_sum(t.root);
    }

    private static int odd_even_level_sum(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        int oddsum = 0;
        int evensum = 0;
        boolean flag = true;
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Node current = queue.poll();
                if(flag) {
                    oddsum += current.data;
                } else {
                    evensum += current.data;
                }
                int i = 0;
                while (i < current.children.size()) {
                    queue.add(current.children.get(i++));
                }
            }

            flag = !flag;
        }
//        System.out.println(oddsum + " " + evensum);
        return Math.abs(oddsum - evensum);
    }


    public void display() {
        display(root);
    }

    private void display(Node node) {
        StringBuilder sb = new StringBuilder(node.data + "-> ");
        for(Node child : node.children) {
            sb.append(child.data + ", ");
        }
        sb.append(".");
        System.out.println(sb.toString());
        for(Node child : node.children) {
            display(child);
        }
    }


}
