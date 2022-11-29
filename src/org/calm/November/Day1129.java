package org.calm.November;
/**
 * ------------------------
 *1758.easy 生成交替二进制字符串的最少操作数
 * ------------------------
 * @author liyang
 * @date 2022/11/29
 * @version 1.0
 * ------------------------
 */
public class Day1129 {
    // 要么以0开始，要么以1开始
    public int minOperations(String s) {
        int cnt = 0, n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++ ) {
            cnt += cs[i] ^ '0' ^ (1 & i);
        }
        return Math.min(cnt, n - cnt);
    }
}
