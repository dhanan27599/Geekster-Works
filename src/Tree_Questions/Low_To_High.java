package Tree_Questions;

public class Low_To_High {
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
    }

    private static void solve(TreeNode root) {
        solve(root.val + " -> ", root.left, root.val, 100, 200);
        solve(root.val + " -> ", root.right, root.val, 100, 200);
    }

    private static void solve(String s, TreeNode child, int sum, int low, int high) {
        if(child == null) {
            return;
        }
        if(child.left == null && child.right == null) {
            sum += child.val;
            s += child.val;
            if(sum > low && sum < high) {
                System.out.println(s);
            }
            return;
        }


        s += child.val;
        solve(s + " -> ", child.left, sum + child.val, low, high);
        solve(s + " -> ", child.right, sum + child.val, low, high);
    }
}
