package org.calm.September;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/9/17
 * @version 1.0
 * ------------------------
 */
public class Day0917 {
    public static void main(String[] args) {

    }

    public int maxLengthBetweenEqualCharacters(String s) {

        int n = s.length();
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        /**
         * "cabbac"
         */
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - 'a';
            end[x] = i;
            if (start[x] == -1) {
                start[x] = i;
            } else {
                ans = Math.max(i - start[x], ans);
            }
        }
        return ans;
    }
}
