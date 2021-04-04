package Tree_Questions;
import java.util.*;

public class Path_To_Leaves {
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

        ArrayList<TreeNode> result = solve(root, 87);

        System.out.println(result);

    }

    public static ArrayList<TreeNode> solve(TreeNode node, int data) {
        if (node == null) {
            ArrayList<TreeNode> br = new ArrayList<TreeNode>();
            return br;
        }

        if (node.val == data) {
            ArrayList<TreeNode> br = new ArrayList<TreeNode>();
            br.add(node);
            return br;
        }
        ArrayList<TreeNode> list = solve(node.left, data);
        if (list.size() > 0) {
            list.add(node);
            return list;
        }

        ArrayList<TreeNode> list1 = solve(node.right, data);
        if (list1.size() > 0) {
            list1.add(node);
            return list1;
        }

        return new ArrayList<TreeNode>();
    }
}
