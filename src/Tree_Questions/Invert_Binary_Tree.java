package Tree_Questions;

import java.util.Stack;

public class Invert_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        inorder(root);
        TreeNode result = solve(root);
        inorder(result);

    }

    private static TreeNode solve(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);

        root.left = right;
        root.right = left;

        return root;
    }


    public static void inorder(TreeNode root) {
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
                System.out.print(current.node.val + " ");
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
        System.out.println();
    }

}
