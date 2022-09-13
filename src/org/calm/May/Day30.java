package org.calm.May;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/30
 * @version: v1.0
 * ---------------------------
 */
public class Day30 {

    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public static void main(String[] args) {
        String str = "100";
        System.out.println(Integer.parseInt(str, 2));
    }
    public int sumRootToLeaf(TreeNode root) {
        dfs(root);
        int sum = 0;
        for (String str : res) {
            sum += Integer.parseInt(str, 2);
        }
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(String.join("", path));
        }
        path.add(root.val + "");
        dfs(root.left);
        dfs(root.right);
        path.removeLast();
    }

}
