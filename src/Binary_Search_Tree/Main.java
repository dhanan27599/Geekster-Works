package Binary_Search_Tree;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 5, 4, 20, 21, 18, 19};
        BinarySearchTree tree = new BinarySearchTree();
        tree.addUsingArray(arr);
//        tree.preorder();
//        tree.inorder();
//        tree.postorder();
//        tree.diameterLength();
//        System.out.println(tree.max() + " " + tree.min());

//        tree.printInRange(tree.min(), tree.max());

//        tree.replaceSumOfLargerNodes();
//        tree.inorder();

//        tree.remove(10);
//        tree.inorder();

//        System.out.println(tree.lca(18, 21));
        tree.targetSumPair(25);
    }
}
