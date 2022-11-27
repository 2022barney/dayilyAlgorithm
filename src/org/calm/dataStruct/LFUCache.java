package org.calm.dataStruct;

import java.util.HashMap;
import java.util.Map;

/**
 * ------------------------
 *460.LFU 容量满时，删除最不常使用中最久的key
 * ------------------------
 * @author liyang
 * @date 2022/11/27
 * @version 1.0
 * ------------------------
 */
public class LFUCache {
    int minFreq, capacity;
    Map<Integer, LFUNode> keyTable;
    Map<Integer, DoubleLinkedList> freqTable;

    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.capacity = capacity;
        keyTable = new HashMap<>();
        freqTable = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!keyTable.containsKey(key)) {
            return -1;
        }

        LFUNode node = keyTable.get(key);
        int val = node.val, freq = node.freq;

        freqTable.get(freq).remove(node);

        // 如果当前链表为空,需要在哈希表中删除，并更新minFreq
        if (freqTable.get(freq).size == 0) {
            freqTable.remove(freq);
            if (minFreq == freq) {
                minFreq += 1;
            }
        }

        // 插入到freq + 1中
        DoubleLinkedList list = freqTable.getOrDefault(freq + 1, new DoubleLinkedList());
        list.addFirst(new LFUNode(key, val, freq + 1));
        freqTable.put(freq + 1, list);
        keyTable.put(key, freqTable.get(freq + 1).getHead());
        return val;
    }


    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!keyTable.containsKey(key)) {
            // 缓存已满，需要进行删除操作
            if (keyTable.size() == capacity) {
                // 通过 minFreq 拿到freqTable[minFreq] 链表的末尾节点
                LFUNode node = freqTable.get(minFreq).getTail();
                keyTable.remove(node.key);
                freqTable.get(minFreq).remove(node);
                if (freqTable.get(minFreq).size == 0) {
                    freqTable.remove(minFreq);
                }
            }

            DoubleLinkedList list = freqTable.getOrDefault(1, new DoubleLinkedList());
            list.addFirst(new LFUNode(key, value, 1));
            freqTable.put(1, list);
            keyTable.put(key, freqTable.get(1).getHead());
            minFreq = 1;
        } else {
            // 与get操作一致，除了需要更新缓存的值
            LFUNode node = keyTable.get(key);
            int freq = node.freq;

            freqTable.get(freq).remove(node);
            // 如果当前链表为空,需要在哈希表中删除，并更新minFreq
            if (freqTable.get(freq).size == 0) {
                freqTable.remove(freq);
                if (minFreq == freq) {
                    minFreq += 1;
                }
            }

            // 插入到freq + 1中
            DoubleLinkedList list = freqTable.getOrDefault(freq + 1, new DoubleLinkedList());
            list.addFirst(new LFUNode(key, value, freq + 1));
            freqTable.put(freq + 1, list);
            keyTable.put(key, freqTable.get(freq + 1).getHead());
        }
    }
}

class LFUNode {
    int key, val, freq;

    LFUNode pre, next;

    LFUNode() {
        this(-1, -1, 0);
    }

    LFUNode(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}

class DoubleLinkedList {
    LFUNode dummyHead, dummyTail;

    int size;

    DoubleLinkedList() {
        dummyHead = new LFUNode();
        dummyTail = new LFUNode();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        size = 0;
    }

    void addFirst(LFUNode node) {
        LFUNode preHead = dummyHead.next;
        node.pre = dummyHead;
        dummyHead.next = node;
        node.next = preHead;
        preHead.pre = node;
        size++;
    }

    void remove(LFUNode node) {
        LFUNode pre = node.pre, next = node.next;
        pre.next = next;
        next.pre = pre;
        size--;
    }

    LFUNode getHead() {
        return dummyHead.next;
    }

    LFUNode getTail() {
        return dummyTail.pre;
    }
}
