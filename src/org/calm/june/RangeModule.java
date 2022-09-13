package org.calm.june;

import java.util.*;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/20
 * @version: v1.0
 * ---------------------------
 */
class RangeModule {

    PriorityQueue<int[]> q1;
    PriorityQueue<int[]> q2;

    public static void main(String[] args) {
        int[] potions = {3, 7, 4};
        TreeMap<Integer, Integer> map = new TreeMap<>(Map.of(3, 3));
        for (int i = potions.length - 1; i >= 0; i--) {
            map.put( potions[i], i);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            System.out.println(integerIntegerEntry.getKey());
        }
    }
    public RangeModule() {
        q1 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q2 = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    }

    public void addRange(int left, int right) {
        if (q1.isEmpty()) {
            q1.add(new int[]{left, right});
            q2.add(new int[]{left, right});
        } else {

        }
    }

    public boolean queryRange(int left, int right) {
        return true;
    }

    public void removeRange(int left, int right) {

    }
}
