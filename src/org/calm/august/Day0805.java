package org.calm.august;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * ---------------------------
 * 623.medium
 * ---------------------------
 * @author: liyang
 * @date: 2022/8/5
 * @version: v1.0
 * ---------------------------
 */
public class Day0805 {
    public static void main(String[] args) {
        int c = '9' - '0';
        char t = '1';
        System.out.println(c);
    }
    public Tre addOneRow(Tre root, int val, int depth) {

        if (root == null) {
            return new Tre(val);
        }
        List<Tre> list = new ArrayList<>();

        dfs(list, root, depth, 0);
        for (Tre node : list) {
            Tre left = node.left;
            Tre right = node.right;
            Tre newLeft = new Tre(val);
            Tre newRight = new Tre(val);
            node.left = newLeft;
            node.right = newRight;
            newLeft.left = left;
            newRight.right = right;
        }
        return root;
    }

    void dfs(List<Tre> list, Tre root, int depth, int level) {
        if (root == null) {
            return;
        }
        if (level == depth - 1) {
            list.add(root);
        }
        level++;
        dfs(list, root.left, depth, level);
        dfs(list, root.right, depth, level);
        level--;
    }
}

class Tre {
    int val;
    Tre left;
    Tre right;
    Tre() {}
    Tre(int val) { this.val = val; }
    Tre(int val, Tre left, Tre right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
