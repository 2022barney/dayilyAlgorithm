package org.calm.May;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/15
 * @version: v1.0
 * ---------------------------
 */
public class Day0515 {
    public static void main(String[] args) {
        String[] strs = {"abba","baba","bbaa","cd","cd"};
        List<String> stringList = removeAnagrams(strs);
        System.out.println(stringList);
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        Map<Integer,int[]> map = new HashMap<>();
        int[] initArray = new int[26];
        for (int c : words[0].toCharArray()) {
            initArray[c - 'a']++;
        }
        map.put(0, initArray);
        if (words.length == 1) {
            res.add(words[0]);
            return res;
        }
        out:for(int i = 1; i < words.length; i++) {
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int[] value = entry.getValue();
                int[] temp = value;
                int[] n = new int[26];
                for (char c : words[i].toCharArray()) {
                    n[c - 'a']++;
                    temp[c - 'a']--;
                }
                for (int j : temp ){
                    if (j != 0) {
                        map.put(i, n);
                        res.add(words[i]);
                        continue out;
                    }
                }
            }
        }
        return res;
    }
}
