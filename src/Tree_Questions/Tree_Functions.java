package Tree_Questions;

public class Tree_Functions {
    public static void add(TreeNode newTreeNode, int atWhichToAdd ,TreeNode root, Character position) {

        if(root == null) {
            root = newTreeNode;
            return;
        }
        TreeNode current = find(atWhichToAdd, root);
        if(position == 'L' && current.left == null) {
            current.left = newTreeNode;
            return;
        } else if(position == 'R' && current.right == null) {
            current.right = newTreeNode;
            return;
        }
        throw new RuntimeException("already TreeNode present");

    }

    public static TreeNode find(int number, TreeNode root) {
        if(root == null)
            return null;
        if(root.val == number)
            return root;

        TreeNode fromLeft = find(number,root.left);
        TreeNode fromRight = find(number, root.right);

        return fromLeft != null ? fromLeft : fromRight;
    }

    public static void display(TreeNode node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left != null ? node.left.val + "->" : ".->";
        str += node.right != null ? node.val + "<-" + node.right.val : node.val + "<-.";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

}
