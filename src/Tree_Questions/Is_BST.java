package Tree_Questions;

public class Is_BST {
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

    public static boolean solve(TreeNode root) {
        return isBST(root).Isbalanced;
    }

    private static Pair4 isBST(TreeNode root) {
        if (root == null) {
            Pair4 p = new Pair4();
            p.Isbalanced = true;
            p.max = Integer.MIN_VALUE;
            p.min = Integer.MAX_VALUE;
            return p;
        }

        Pair4 lpair = isBST(root.left);
        Pair4 rpair = isBST(root.right);

        if (lpair.Isbalanced == false || rpair.Isbalanced == false) {
            Pair4 p = new Pair4();
            p.Isbalanced = false;
            return p;
        }

        Pair4 mpair = new Pair4();
        mpair.max = Math.max(lpair.max, Math.max(rpair.max, root.val));
        mpair.min = Math.min(lpair.min, Math.min(rpair.min, root.val));
        if (root.val > lpair.max && root.val < rpair.min) {
            mpair.Isbalanced = true;
        }

        return mpair;
    }

}
