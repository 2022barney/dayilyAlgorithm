package org.calm.july;

/**
 * ---------------------------
 * 1217. easy
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/8
 * @version: v1.0
 * ---------------------------
 */
public class Day0708 {

    public int minCostToMoveChips(int[] position) {
        int a = 0;
        for (int p : position) {
           if (p % 2 == 0) a++;
        }
        return Math.min(a, position.length - a);
    }

}
