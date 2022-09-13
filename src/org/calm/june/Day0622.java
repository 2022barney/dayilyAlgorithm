package org.calm.june;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/22
 * @version: v1.0
 * ---------------------------
 */
public class Day0622 {
    public static void main(String[] args) {
        System.out.println();
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<TreeNode>> total = new ArrayList<>();
        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.add(root);
        while (!queue.isEmpty() ){
            int size = queue.size();
            List<TreeNode> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode first = queue.poll();
                curLevel.add(first);

                //if (first.left != null) {
                //    queue.add(first.left);
                //}
                //if (first.right != null) {
                //    queue.add(first.right);
                //}
            }
        }
        List<TreeNode> nodes = total.get((total.size() - 1));
        //return nodes.get(0).val;
        return 0;
    }
}
