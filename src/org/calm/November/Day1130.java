package org.calm.November;

import java.util.*;

/**
 * ------------------------
 *895.hard 最大频率栈
 * ------------------------
 * @author liyang
 * @version 1.0
 * ------------------------
 * @date 2022/11/30
 */
public class Day1130 {


    /**
     * 0 <= val <= 109
     * push 和 pop 的操作数不大于 2 * 104。
     * 输入保证在调用 pop 之前堆栈中至少有一个元素。
     */
    Map<Integer, Integer> valTable;
    TreeMap<Integer, Set<Integer>> freqTable;
    int maxFreq;
    DoubleLinkList doubleLink;

    public Day1130() {
        valTable = new HashMap<>();
        freqTable = new TreeMap<>();
        maxFreq = 0;
        doubleLink = new DoubleLinkList();
    }

    public void push(int val) {
        if (!valTable.containsKey(val)) {
            MyNode node = new MyNode(val, 1);
            valTable.put(val, 1);
            freqTable.computeIfAbsent(1, x -> new HashSet<>()).add(val);
            maxFreq = Math.max(maxFreq, 1);
            doubleLink.addFirst(node);
        } else {
            int freq = valTable.get(val) + 1;
            MyNode node = new MyNode(val, freq);
            valTable.put(val, freq);
            freqTable.computeIfAbsent(freq,x -> new HashSet<>()).add(val);
            maxFreq = Math.max(maxFreq, freq);
            doubleLink.addFirst(node);
        }

    }

    public int pop() {

        int size = doubleLink.cnt;

        MyNode t = doubleLink.head.next;
        while (size-- > 0 && t.freq != maxFreq) {
            t = t.next;
        }
        doubleLink.delNode(t);
        int ans = t.val;
        valTable.put(ans, t.freq - 1);

        Set<Integer> set = freqTable.get(maxFreq);
        set.remove(ans);
        if (set.size() == 0) {
            freqTable.remove(maxFreq);
        }

        if (freqTable.size() > 0) {
            System.out.println(" xx " + freqTable.lastKey());
            maxFreq = freqTable.lastKey();
        } else {
            maxFreq = 0;
        }
        return ans;
    }
}

class MyNode {
    int val, freq;

    MyNode pre;
    MyNode next;

    MyNode() {

    }

    MyNode(int key, int freq) {
        this.val = key;
        this.freq = freq;
    }
}

class DoubleLinkList {

    int cnt = 0;
    MyNode head = new MyNode(), tail = new MyNode();
    DoubleLinkList() {
        head.next = tail;
        tail.pre = head;
    }
    void addFirst(MyNode node)  {
        MyNode next = head.next;
        head.next = node;
        node.pre = head;

        node.next = next;
        next.pre = node;
        cnt++;
    }

    void addTail(MyNode node)  {
        MyNode pre = tail.pre;
        tail.pre = node;
        node.next = tail;

        node.pre = pre;
        pre.next = node;
        cnt++;
    }

    void delNode(MyNode node)  {
        MyNode pre = node.pre;
        MyNode next = node.next;

        pre.next = next;
        next.pre = pre;
        cnt--;
    }

}
