package Tree_Questions;

public class Print_K_Down {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        Tree_Functions.add(new TreeNode(25), 50, root, 'L');
        Tree_Functions.add(new TreeNode(75), 50, root, 'R');
        Tree_Functions.add(new TreeNode(12), 25, root, 'L');
        Tree_Functions.add(new TreeNode(37), 25, root, 'R');
        Tree_Functions.add(new TreeNode(30), 37, root, 'L');
        Tree_Functions.add(new TreeNode(40), 37, root, 'R');
        Tree_Functions.add(new TreeNode(62), 75, root, 'L');
        Tree_Functions.add(new TreeNode(87), 75, root, 'R');
        Tree_Functions.add(new TreeNode(60), 62, root, 'L');
        Tree_Functions.add(new TreeNode(70), 62, root, 'R');

        solve(root, 1);
    }

    public static void solve(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.println(root.val);
        }

        solve(root.left, k - 1);
        solve(root.right, k - 1);
    }
}
