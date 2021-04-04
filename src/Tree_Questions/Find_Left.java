package Tree_Questions;

public class Find_Left {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(solve(root, 2));
    }

    // Similarly we can create find_right

    public static int solve(TreeNode root, int num) {
        if(root == null || root.left == null) {
            return -1;
        }

        if(root.val == num) {
            return root.left.val;
        }

        int left = solve(root.left, num);
        int right = solve(root.right, num);

        return left != -1 ? left : right;
    }
}
