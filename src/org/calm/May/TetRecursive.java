package org.calm.May;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/29
 * @version: v1.0
 * ---------------------------
 */
public class TetRecursive {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(7);
        TreeNode leftLeft = new TreeNode(2);
        TreeNode leftRight = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(8);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;

        dfs(root);
    }
    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        new StringBuilder().append('c');
        String a = "aa";
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }
    public TreeNode(int val) {
        this.val = val;
    }
}