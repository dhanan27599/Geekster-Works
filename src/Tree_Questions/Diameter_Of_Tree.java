package Tree_Questions;

public class Diameter_Of_Tree {
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

        System.out.println(solve(root));
    }

    public static int solve(TreeNode root) {
        return diameterHelper(root).maxDiameter;
    }

    private static Pair2 diameterHelper(TreeNode root) {
        if(root == null) {
            return new Pair2(0, 0);
        }

        Pair2 left = diameterHelper(root.left);
        Pair2 right = diameterHelper(root.right);
        int maxdiameter = left.height + right.height + 1;

        int max = Math.max(maxdiameter, Math.max(left.maxDiameter, right.maxDiameter));

        return new Pair2(Math.max(left.height, right.height) + 1, max);
    }

}
