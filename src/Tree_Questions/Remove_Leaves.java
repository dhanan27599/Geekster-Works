package Tree_Questions;

public class Remove_Leaves {
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

        solve(null, root);

        Tree_Functions.display(root);


    }

    public static void solve(TreeNode parent, TreeNode child) {
        if(child == null) {
            return;
        }
        if(child.left == null && child.right == null) {
            if(parent.left == child) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return;
        }

        solve(child, child.left);
        solve(child, child.right);
    }


}
