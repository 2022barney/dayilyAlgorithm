package org.calm.May;

import java.util.Arrays;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/15
 * @version: v1.0
 * ---------------------------
 */
public class Day0515_2 {
    public static void main(String[] args) {
        int i = maxConsecutive(6, 8, new int[]{7,6, 8});
        System.out.println(i);
    }
    public static int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int start = special[0];
        int end = special[special.length - 1];

        int max = 0;
        int init = special[0];
        for (int i = 1; i < special.length; i++) {
            int t = special[i] - init;
            init = special[i];
            max = Math.max(t, max);
        }
        max = max - 1;
        int m1 = start - bottom;
        int m2 = top - end;
        return Math.max(max, Math.max(m1, m2));

    }
}
