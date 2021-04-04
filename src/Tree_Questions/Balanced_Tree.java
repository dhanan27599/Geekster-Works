package Tree_Questions;

public class Balanced_Tree {
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

        System.out.println(solve(root));
    }

    private static boolean solve(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean leftcheck = solve(root.left);
        boolean rightcheck = solve(root.right);

        if(rightcheck == false) {
            return false;
        }

        int leftheight = findheight(root.left);
        int rightheight = findheight(root.right);

        if(leftheight - rightheight >= -1 && leftheight - rightheight <= 1) {
            return true;
        }

        return false;
    }

    public static int findheight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = findheight(root.left);
        int right = findheight(root.right);

        return Math.max(left, right) + 1;
    }
}
