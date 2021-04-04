package Tree_Questions;

public class Max_Sum_Of_Depth {
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

        solve(root);
        System.out.println(sum);
    }

    static int sum;
    static int maxlevel;
    public static void solve(TreeNode root) {
        sum = 0;
        maxlevel = 0;
        solve(root, 1);
    }

    private static void solve(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(maxlevel == level) {
            sum += root.val;
        }

        if(maxlevel < level) {
            sum = root.val;
            maxlevel = level;
        }

        solve(root.left, level + 1);
        solve(root.right, level + 1);
    }

}
