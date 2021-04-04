package Tree_Questions;

import java.util.Stack;

public class Inorder_Iterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(8);
        root.right.right = new TreeNode(7);

        solve(root);
    }

    /**
     * In-order Traversal -- Rules
     *
     * 0) Call for Left
     * 1) Print Current Node
     * 2) Call for Right
     *
     */

    public static void solve(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        Pair pair = new Pair(root, 0);
        stack.push(pair);

        while(stack.size() > 0) {
            Pair current = stack.peek();

            //* Rule 0
            if(current.workcount == 0) {
                if(current.node.left != null) {
                    Pair left = new Pair(current.node.left, 0);
                    stack.push(left);
                }
                current.workcount += 1;
            }

            //* Rule 1
            else if(current.workcount == 1) {
                System.out.println(current.node.val);
                current.workcount += 1;
            }

            //* Rule 2
            else if(current.workcount == 2) {
                if(current.node.right != null) {
                    Pair right = new Pair(current.node.right, 0);
                    stack.push(right);
                }
                current.workcount += 1;
            }

            else {
                stack.pop();
            }
        }
    }
}
