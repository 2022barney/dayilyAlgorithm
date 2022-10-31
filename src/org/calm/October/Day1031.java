package org.calm.October;
/**
 * ------------------------
 * 481. medium 神奇字符串
 * ------------------------
 * @author liyang
 * @date 2022/10/31
 * @version 1.0
 * ------------------------
 */
public class Day1031 {
    public int magicalString(int n) {
        /**
         * 1 22 11 2 1 22 1 22 11
         * 1 2  2  1 1 2  1 2  2
         */

        int[] magic = new int[n + 1];
        magic[0] = 1;
        int ans = 1, value = 1, count = 2,  p = 1, tail = 1;
        while (tail < n) {
            value ^= 3;
            while (count-- > 0 && tail < n) {
                magic[tail++] = value;
                if (value == 1) ans++;
            }
            count = magic[++p];
        }
        return ans;
    }
}
