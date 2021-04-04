package Tree_Questions;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val + "";
    }
}
