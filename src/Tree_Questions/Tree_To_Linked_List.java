package Tree_Questions;

public class Tree_To_Linked_List {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        solve(root);

        while(root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }


    private static void solve(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            return;
        }

        if(root.left != null) {
            solve(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;

            TreeNode current = root.right;
            while (current.right != null) {
                current = current.right;
            }
            current.right = temp;
        }

        solve(root.right);
    }

}
