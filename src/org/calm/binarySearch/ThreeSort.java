package org.calm.binarySearch;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/7
 * @version: v1.0
 * ---------------------------
 */
public class ThreeSort {

    public static void main(String[] args) {
        //int i = waysToSplit(new int[]{1, 2, 2, 2, 5, 0});
        int i = waysToSplit(new int[]{1, 1, 1});
        System.out.println(i);
    }

    public static int waysToSplit(int[] nums) {

        final int MOD = 1000000000 + 7;
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        long ans = 0;
        for (int i = n - 2; i > 0; i--) {
            int v3 = presum[n] - presum[i];
            int l = 0, r = i + 1;
            while (l + 1 != r) {
                int m = l + r >> 1;
                if (check(i, v3, m, presum)) {
                    r = m;
                } else {
                    l = m;
                }
            }
            if (r != i - 1) {
                ans += i - r;
            }
        }
        return (int) (ans % MOD);
    }

    static boolean check(int i, int v3, int m, int[] presum) {
        int v2 = presum[i] - presum[m - 1];
        int v1 = presum[m] - presum[0];
        return v3 >= v2 && v2 >= v1;
    }
}


/**
 * static int MOD = 1000000000 + 7;
 *     public int waysToSplit(int[] nums) {
 *         int n = nums.length;
 *         int[] presums = new int[n + 1];
 *         for (int i = 0; i < n; i++) {
 *             presums[i + 1] = presums[i] + nums[i];
 *         }
 *         long ans = 0;
 *         int m = 2;
 *         for (int i = 1; i <= n - 2; i++) {
 *             int L = presums[i];
 *             m = Math.max(m, i + 1);
 *             while (m < n && presums[m + 1] - L < L) {
 *                 m++;
 *             }
 *             if (m == n) {
 *                 break;
 *             }
 *             int l = m , r = n;
 *             while (l + 1 < r) {
 *                 int c = l + r >> 1;
 *                 if (presums[n + 1] - presums[c + 1] < presums[c + 1] - L) {
 *                     r = c - 1;
 *                 }else {
 *                     l = c + 1;
 *                 }
 *             }
 *             ans += r - m + 1;
 *         }
 *         return (int)(ans % MOD);
 *     }
 */
