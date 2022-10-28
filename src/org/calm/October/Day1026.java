package org.calm.October;

import java.util.ArrayDeque;

/**
 * ------------------------
 * 862.hard
 * ------------------------
 * @author liyang
 * @date 2022/10/26
 * @version 1.0
 * ------------------------
 */
public class Day1026 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, ans = n + 1;
        var preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        var q = new ArrayDeque<Integer>();
        for (var i = 0; i <= n; i++) {
            var curS = preSum[i];
            while (!q.isEmpty() && curS - preSum[q.peekFirst()] >= k) {
                ans = Math.min(ans, i - q.pollFirst());
            }
            while (!q.isEmpty() && preSum[q.peekLast()] >= curS)
                q.pollLast();
            q.addLast(i);
        }
        return ans > n ? -1 :ans;
    }
}
