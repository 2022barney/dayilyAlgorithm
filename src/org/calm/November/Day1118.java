package org.calm.November;

import java.util.Arrays;

/**
 * ------------------------
 *891.hard
 * ------------------------
 * @author liyang
 * @date 2022/11/18
 * @version 1.0
 * ------------------------
 */
public class Day1118 {
    public static final int MOD = (int)1e9 + 7;
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);

        var n = nums.length;
        var pow = new int[n];

        pow[0] = 1;
        for (var i = 0; i < n; i++) {
            pow[i] = pow[i - 1] * 2 % MOD;
        }
        var ans = 0L;
        for (int i = 0; i < n; i++) {
            ans += (long)(pow[i] - pow[n - i - 1] * nums[i]);
        }
        return (int)(ans % MOD + MOD) % MOD;
    }

    public static void main(String[] args) {
        System.out.println(-1 % 10);
    }
}
