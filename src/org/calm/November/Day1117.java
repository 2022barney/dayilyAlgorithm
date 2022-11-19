package org.calm.November;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ------------------------
 *792.medium
 * ------------------------
 * @author liyang
 * @date 2022/11/17
 * @version 1.0
 * ------------------------
 */
public class Day1117 {
    /**
     * 输入: s = "abcde", words = ["a","bb","acd","ace"]
     * 输出: 3
     * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
     *
     * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
     * 输出: 2
     * @param s
     * @param words
     * @return
     */
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }

        int ans = words.length;

        for (String word : words) {
            if (word.length() > s.length()) {
                ans--;
                continue;
            }

            int p = -1;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (map.get(c) == null || map.get(c).get(map.get(c).size() - 1) <= p) {
                    --ans;
                    break;
                }
                p = binarySearch(map.get(c), p);
            }
        }
        return ans;
    }

    int binarySearch(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l  < r) {
            int m = l + r >> 1;
            if (list.get(m) > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return list.get(r);
    }
}
