package org.calm.dataStruct.skiplist;

import java.util.Random;

/**
 * ---------------------------
 * 宫水三叶题解
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/26
 * @version: v1.0
 * ---------------------------
 */
public class Skiplist2 {

    int level = 10;

    class Node {
        int val;
        Node[] ne = new Node[level];

        Node(int _val) {
            val = _val;
        }
    }

    Random random = new Random();
    Node he = new Node(-1);

    void find(int t, Node[] ns) {
        Node cur = he;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.ne[i] != null && cur.ne[i].val < t) {
                cur = cur.ne[i];
            }
            ns[i] = cur;
        }
    }

    public boolean search(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        return ns[0].ne[0] != null && ns[0].ne[0].val == t;
    }

    public void add(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = new Node(t);
        for (int i = 0; i < level; i++) {
            node.ne[i] = ns[i].ne[i];
            ns[i].ne[i] = node;
            if (random.nextInt(2) == 0) {
                break;
            }
        }
    }

    public boolean erase(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = ns[0].ne[0];
        if (node == null || node.val != t) {
            return false;
        }
        for (int i = 0; i < level && ns[i].ne[i] == node; i++) ns[i].ne[i] = ns[i].ne[i].ne[i];
        return true;
    }
}
