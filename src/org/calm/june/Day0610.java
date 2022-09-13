package org.calm.june;

import java.util.Arrays;

/**
 * ---------------------------
 *
 * ---------------------------
 * @author: liyang
 * @date: 2022/6/10
 * @version: v1.0
 * ---------------------------
 */
public class Day0610 {

    /**
     * 输入：s = 'bccb'
     输出：6
     解释：6 个不同的非空回文子字符序列分别为：'b', 'c', 'bb', 'cc', 'bcb', 'bccb'。
     注意：'bcb' 虽然出现两次但仅计数一次。

     输入：s = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
     输出：104860361
     解释：共有 3104860382 个不同的非空回文子序列，104860361 对 109 + 7 取模后的值。
     */
    public int countPalindromicSubsequences(String s) {
        int mod = (int)1e9 + 7;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] fn = new int[n][n];
        int[] left = new int[4];
        int[] right = new int[4];
        Arrays.fill(left, -1);
        for (int i = n - 1; i >= 0; i--) {
            left[chars[i] - 'a'] = i;
            Arrays.fill(right, -1);
            for (int j = i; j < n; i++) {
                right[chars[j] - 'a'] = j;
                for (int k = 0; k < 4; k++) {
                    if (left[k] == -1 || right[k] == -1) continue;
                    int l = left[k], r = right[k];
                    if (l == r) {
                        fn[i][j] = (fn[i][j] + 1) % mod;
                    }else if (l == r - 1) {
                        fn[i][j] = (fn[i][j] + 2) % mod;
                    }else {
                        fn[i][j] = (fn[i][j] + fn[l + 1][r - 1] + 2) % mod;
                    }
                }
            }
        }

        return fn[0][n - 1];
    }
}
