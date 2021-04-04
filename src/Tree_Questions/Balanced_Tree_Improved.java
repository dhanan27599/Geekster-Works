package Tree_Questions;

public class Balanced_Tree_Improved {
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
        Tree_Functions.add(new TreeNode(90), 87, root, 'R');
//        Tree_Functions.add(new TreeNode(100), 90, root, 'R');

        System.out.println(isBalancedHelper(root));
    }

    public static boolean isBalancedHelper(TreeNode root) {
        return solve(root).balance;
    }

    public static Pair1 solve(TreeNode root) {
        if (root == null) {
            return new Pair1(0, true);
        }
        Pair1 leftp = solve(root.left);
        Pair1 rightp = solve(root.right);
        if (leftp.balance == false || rightp.balance == false) {
            return new Pair1(Math.max(leftp.height, rightp.height) + 1, false);
        }

        if (leftp.height - rightp.height >= -1 && leftp.height - rightp.height <= 1) {
            return new Pair1(Math.max(leftp.height, rightp.height) + 1, true);
        }

        return new Pair1(Math.max(leftp.height, rightp.height) + 1, false);
    }

}
