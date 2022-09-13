package org.calm.june;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ---------------------------
 * 522 medium
 * ---------------------------
 * @author: liyang
 * @date: 2022/6/27
 * @version: v1.0
 * ---------------------------
 */
public class Day0627 {
    public int findLUSlength(String[] strs) {
        //["aabbcc", "aabbcc","cb"]
        int ans = -1;
        out:for (int i = 0; i < strs.length; i++) {
                for (int j = 0; j < strs.length; j++) {
                    if (strs[i].length() > strs[j].length()) {
                        if (i != j && isSubStr(strs[i], strs[j])) {
                            continue out;
                        }
                    }
                    ans = strs[i].length();
                }
        }
        return ans;
    }

    boolean isSubStr(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == m;
    }
}
