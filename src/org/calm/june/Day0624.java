package org.calm.june;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ---------------------------
 * 515, medium
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/24
 * @version: v1.0
 * ---------------------------
 */
public class Day0624 {
    public static void main(String[] args) {

    }

    /*public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                max = Math.max(max, poll.val);

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }*/
}
