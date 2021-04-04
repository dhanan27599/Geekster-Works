package Tree_Questions;

public class Is_Inverted {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);

        root2 = invert(root2);

        System.out.println(solve(root1, root2));
    }

    private static boolean solve(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 != null && root2 != null && root1.val == root2.val) {
            return solve(root1.left, root2.right) && solve(root1.right, root2.left);
        }

        return false;
    }

    private static TreeNode invert(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
