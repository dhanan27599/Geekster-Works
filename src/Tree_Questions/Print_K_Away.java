package Tree_Questions;

import java.util.ArrayList;

public class Print_K_Away {
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


        solve(root, 87, 3);
    }

    public static void solve(TreeNode root, int val, int k) {
        ArrayList<TreeNode> path = nodeToRoot(root, val);
        kDown(path.get(0), k);
        for (int i = 1; i < path.size() && i < k; i++) {
            TreeNode n = path.get(i);
            TreeNode nm = path.get(i - 1);

            if (n.left == nm) {
                kDown(n.right, k - i - 1);
            } else {
                kDown(n.left, k - i - 1);
            }
        }

        if (path.size() > k) {
            System.out.println(path.get(k).val);
        }
    }

    public static ArrayList<TreeNode> nodeToRoot(TreeNode node, int data) {
        if (node == null) {
            ArrayList<TreeNode> br = new ArrayList<TreeNode>();
            return br;
        }

        if (node.val == data) {
            ArrayList<TreeNode> br = new ArrayList<TreeNode>();
            br.add(node);
            return br;
        }
        ArrayList<TreeNode> list = nodeToRoot(node.left, data);
        if (list.size() > 0) {
            list.add(node);
            return list;
        }

        ArrayList<TreeNode> list1 = nodeToRoot(node.right, data);
        if (list1.size() > 0) {
            list1.add(node);
            return list1;
        }

        return new ArrayList<TreeNode>();
    }

    public static void kDown(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.println(root.val);
        }

        kDown(root.left, k - 1);
        kDown(root.right, k - 1);
    }
}
