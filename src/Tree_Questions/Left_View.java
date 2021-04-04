package Tree_Questions;

import java.util.*;
public class Left_View {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        solve(root);
    }

    /**
     * Using Recursion
     * Time Complexity -> O(N) Space Complexity -> O(logN) [Call Stack will be the height of the tree]
     */

    static int maxlevel;
    public static void solve(TreeNode root) {
        leftview(root, 1);
        maxlevel = 0;
    }

    private static void leftview(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(maxlevel < level) {
            System.out.println(root.val);
            maxlevel = level;
        }

        leftview(root.left, level + 1);
        leftview(root.right, level + 1);
    }


    /**
     * Using Queue
     * Time Complexity -> O(N) Space Complexity -> O(N) using Queue
     */

//    public static void solve(TreeNode root) {
//        Deque<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            int i = 1;
//            while(size-- > 0) {
//                TreeNode current = queue.poll();
//                if(i-- != 0) {
//                    System.out.println(current.val);
//                }
//                if(current.left != null) {
//                    queue.add(current.left);
//                } if(current.right != null) {
//                    queue.add(current.right);
//                }
//            }
//        }
//    }


}
