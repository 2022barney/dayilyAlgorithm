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
public class Day0620 {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        int ans = 0;
        if (arr[arr.length - 1] - arr.length < k) return k + arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] - m - 1 >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l + k;
    }
}
