package org.calm.august;

/**
 * ---------------------------
 *  622.循环队列
 * ---------------------------
 * @author: liyang
 * @date: 2022/8/2
 * @version: v1.0
 * ---------------------------
 */
public class MyCircularQueue {
    int[] queue;
    int front;
    int tail;
    int cnt;
    int size;
    public MyCircularQueue(int k) {
        queue = new int[k];
        front = -1;
        tail = -1;
        cnt = 0;
        size = k;
    }

    public boolean enQueue(int value) {
        if (cnt == size) {
            return false;
        }
        if (front == -1) {
            queue[0] = value;
            cnt++;
            front++;
            tail++;
        } else {
            queue[(++tail) % size] = value;
            cnt++;
        }
        return true;
    }

    public boolean deQueue() {
        if (cnt == 0) {
            return false;
        }
        front = (front + 1) % size;
        cnt--;
        return true;
    }

    public int Front() {
        return queue[front];
    }

    public int Rear() {
        return queue[tail];
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == size;
    }
}
