package Binary_Search_Tree;
import java.util.*;
public class BinarySearchTree {
    Node root;

    public void add(int data) {
        addUtil(this.root, data);
    }

    public Node addUtil(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }

        if(data < root.data) {
            root.left = addUtil(root.left, data);
        } else if(data > root.data) {
            root.right = addUtil(root.right, data);
        }

        return root;
    }

    public void addUsingArray(int[] arr) {
        for(int i : arr) {
            this.root = addUtil(this.root, i);
        }
    }

    public void preorder() {
        preorder(this.root);
        System.out.println();
    }

    private void preorder(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder() {
        inorder(this.root);
        System.out.println();
    }

    private void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void postorder() {
        postorder(this.root);
        System.out.println();
    }

    private void postorder(Node root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    //! Diameter Of Tree
    public int diameterLength() {
        Pair p = diameterLength(this.root);
        System.out.println(p.b);
        return p.b;
    }

    private Pair diameterLength(Node root) {
        if(root == null) {
            return new Pair(0, 0);
        }

        Pair leftDia = diameterLength(root.left);
        Pair rightDia = diameterLength(root.right);

        int maxheight = Math.max(leftDia.a, rightDia.a) + 1;
        int maxdia = Math.max(Math.max(leftDia.b, rightDia.b), leftDia.a + rightDia.a + 1);

        return new Pair(maxheight, maxdia);
    }

    public int min() {
        return min(this.root);
    }

    private int min(Node root) {
        if(root.left == null) {
            return root.data;
        }
        return min(root.left);
    }

    public int max() {
        return max(this.root);
    }

    private int max(Node root) {
        if(root.right == null) {
            return root.data;
        }
        return max(root.right);
    }
    //! Print In Ranges
    public void printInRange(int low, int high) {
        printInRange(this.root, low, high);
    }

    private void printInRange(Node root, int low, int high) {
        if(root != null) {
            if(root.data > high) {
                printInRange(root.left, low, high);
            } else if(root.data >= low && root.data <= high) {
                System.out.println(root.data);
                printInRange(root.left, low, high);
                printInRange(root.right, low, high);
            } else {
                printInRange(root.right, low, high);
            }
        }
    }
    //! Replace Sum Of Larger Nodes
    private int sum;
    public void replaceSumOfLargerNodes() {
        sum = 0;
        replaceSumOfLargerNodes(root);
    }

    private void replaceSumOfLargerNodes(Node root) {
        if(root != null) {
            replaceSumOfLargerNodes(root.right);
            int temp = root.data;
            root.data = sum;
            sum += temp;
            replaceSumOfLargerNodes(root.left);
        }
    }
    //! Remove Nodes
    public void remove(int k) {
        this.root = remove(this.root, k);
    }

    private Node remove(Node root, int k) {
        if(root.data > k) {
            root.left = remove(root.left, k);
        } else if(root.data < k) {
            root.right = remove(root.right, k);
        }else {
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                int lmax = max(root.left);
                root.data = lmax;
                root.left = remove(root.left, lmax);
            }
        }

        return root;
    }

    //! Lowest Common Ancestor
    public int lca(int a, int b) {
        return lca(this.root, a, b);
    }

    private int lca(Node node, int a, int b) {
        if(a > node.data && b > node.data) {
            return lca(node.right, a, b);
        } else if(a < node.data && b < node.data) {
            return lca(node.left, a, b);
        } else {
            return node.data;
        }
    }
    public void targetSumPair(int target) {
        targetSumPair(this.root, target);
    }

    private void targetSumPair(Node node, int target) {
        if(node != null) {
            if (find(target - node.data)) {
                if(node.data < (target - node.data)) {
                    System.out.println(node.data + ", " + (target - node.data));
                }
            }
            targetSumPair(node.left, target);
            targetSumPair(node.right, target);
        }
    }

    private boolean find(int k) {
        return find(this.root, k);
    }

    private boolean find(Node node, int k) {
        if(node == null) {
            return false;
        }

        if(node.data == k) {
            return true;
        }

        if(k > node.data) {
            return find(node.right, k);
        } else {
            return find(node.left, k);
        }
    }


}
