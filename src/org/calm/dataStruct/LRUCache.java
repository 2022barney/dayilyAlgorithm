package org.calm.dataStruct;

import java.util.HashMap;
import java.util.Map;

/**
 * ------------------------
 *146.medium 最近最少使用的，按使用时间顺序删除(最老的) 也是 最久未使用的
 * ------------------------
 * @author liyang
 * @date 2022/11/27
 * @version 1.0
 * ------------------------
 */
public class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int cur;
    int cap;


    public LRUCache(int capacity) {
        cur = 0;
        cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        insertFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;

            insertFirst(node);
        } else {
            node = new Node();
            node.key = key;
            node.val = value;
            if (cur == cap) {
                int k = tail.pre.key;
                map.remove(k);

                Node pre = tail.pre;
                pre.pre.next = tail;
                tail.pre = pre.pre;

                Node n = head.next;
                head.next = node;
                node.pre = head;
                node.next = n;
                n.pre = node;
            } else {
                cur++;

                Node n = head.next;
                head.next = node;
                node.pre = head;
                node.next = n;
                n.pre = node;
            }
            map.put(key, node);
        }

    }

    void insertFirst(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;

        Node n = head.next;
        head.next = node;
        node.pre = head;
        node.next = n;
        n.pre = node;
    }
}
class Node {
    int key;
    int val;
    Node pre;
    Node next;
}
