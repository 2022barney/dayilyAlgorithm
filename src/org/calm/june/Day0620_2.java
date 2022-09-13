package org.calm.june;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/21
 * @version: v1.0
 * ---------------------------
 */
public class Day0620_2 {

    public int findMissNum(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        if (arr[r] - r < k) return arr.length + k;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] - m - 1 >= k) {
                r = k;
            }else {
                l = m + 1;
            }
        }

        return l + k;
    }
}
