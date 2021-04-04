package GenericTree;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
//
//        GenericTree tree = new GenericTree(arr);
//        System.out.println(tree.nodeToRootPath(120));
//        tree.removeLeaves();
//        tree.display();
//        System.out.println(tree.linearized());
//        tree.linearise2();
//        tree.display();
//        tree.display();
//        tree.mirror();
//        System.out.println();
//        tree.display();

        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        GenericTree tree1 = new GenericTree(arr);
//        int[] arr2 = {100, 200, 500, -1, 6, -1, -1, 300, 700, -1, 800, 10, -1, 12, -1, -1, 9, -1, -1, 4, 10, 22, -1, -1, -1, -1};
        int[] arr2 = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        GenericTree tree2 = new GenericTree(arr2);
//        tree2.mirror();
//        System.out.println(GenericTree.isSymmetric(tree1, tree2));
        System.out.println(GenericTree.odd_even_level_sum(tree1));

//        System.out.println(GenericTree.areSimilarShaped(tree1, tree2));

    }
}
