package Tree_Questions;

import java.util.*;

public class Level_Order_Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        solve(root);
    }


//*  Using Queue

    public static void solve(TreeNode root) {
        if(root == null){
            return;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            System.out.print("Level " + level + ": ");
            while(size-- != 0){
                TreeNode current = queue.poll();
                System.out.print(" " + current.val + " ");
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            level += 1;
            System.out.println();
        }

    }
}
