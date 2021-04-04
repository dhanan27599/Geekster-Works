package Tree_Questions;
import java.util.*;
public class Right_View {
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

    static int max;

    public static void solve(TreeNode root) {
        rightview(root, 1);
        max = 0;
    }

    public static void rightview(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(max < level) {
            System.out.println(root.val);
            max = level;
        }

        rightview(root.right, level + 1);
        rightview(root.left, level + 1);

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
//                if(i -- > 0) {
//                    System.out.println(current.val);
//                }
//                if(current.right != null) {
//                    queue.add(current.right);
//                }
//
//                if(current.left != null) {
//                    queue.add(current.left);
//                }
//            }
//        }
//    }




}
