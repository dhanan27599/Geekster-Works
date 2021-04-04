package Tree_Questions;

import java.util.*;

public class Lowest_Common_Ancestor {
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

        System.out.println(solve(75, 87, root));
    }

    /**
     * Using Node To Leaves Method
     * Time Complexity -> O(N) Space Complexity -> O(N) Using List
     */

    public static int solve(int n1, int n2, TreeNode root) {

        ArrayList<TreeNode> list1 = nodetoroot(root, n1);
        ArrayList<TreeNode> list2 = nodetoroot(root, n2);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        while(i >= 0 && j >= 0 && list1.get(i) == list2.get(j)) {
            i--;
            j--;
        }

        return list1.get(i + 1).val;
    }


    //Node To Leaves Method
    public static ArrayList<TreeNode> nodetoroot(TreeNode node, int data) {
        if (node == null) {
            ArrayList<TreeNode> br = new ArrayList<TreeNode>();
            return br;
        }

        if (node.val == data) {
            ArrayList<TreeNode> br = new ArrayList<TreeNode>();
            br.add(node);
            return br;
        }
        ArrayList<TreeNode> list = nodetoroot(node.left, data);
        if (list.size() > 0) {
            list.add(node);
            return list;
        }

        ArrayList<TreeNode> list1 = nodetoroot(node.right, data);
        if (list1.size() > 0) {
            list1.add(node);
            return list1;
        }

        return new ArrayList<TreeNode>();
    }
}
