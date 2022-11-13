package org.calm.WeedendContest;
/**
 * ------------------------
 * 6238.medium dp
 * ------------------------
 * @author liyang
 * @date 2022/11/13
 * @version 1.0
 * ------------------------
 */
public class Day1112 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = (int)1e9 + 7;
        long[] dp = new long[high + 1];
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) dp[i] = (dp[i] + dp[i - zero]) % MOD;
            if (i >= one) dp[i] = (dp[i] + dp[i - one]) % MOD;
        }
        long res = 0;
        for (int i = low; i <= high; i++) {
            res = (res + dp[i]) % MOD;
        }
        return (int)res;
    }
}
