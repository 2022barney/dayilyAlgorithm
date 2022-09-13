package org.calm.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ---------------------------
 * 滑动窗口,贪心
 * ---------------------------
 * @author: liyang
 * @date: 2022/6/23
 * @version: v1.0
 * ---------------------------
 */
public class Day0623 {
    public static void main(String[] args) {
        String str = "abcd";
        String substring = str.substring(0, 4);
        System.out.println(substring);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wlen = words[0].length();
        int sLen = s.length();
        if (sLen < wlen) {
            return res;
        }

        int flag = 0;
        for (int k = 0; k < sLen - wlen + 1; k++) {
            Map<String, Integer> map = getMap(words);
            int cnt = wlen;
            int init = k, i = k;
            while (i < sLen - wlen + 1) {
                int j = i + wlen - 1;
                String cur = s.substring(i, j + 1);
                if (map.containsKey(cur) && map.get(cur) > 0) {
                    map.put(cur, map.get(cur) - 1);
                    cnt--;
                    if (flag == 0) {
                        flag = 1;
                        init = i;
                    }
                    i = j + 1;
                    if (cnt == 0) {
                        break;
                    }
                }else {
                    if (flag == 1) {
                        break;
                    }
                    i++;
                }
            }
            if (cnt == 0) {
                res.add(init);
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    private Map<String, Integer> getMap(String[] words)
    {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer v = map.getOrDefault(word, 0);
            map.put(word, v + 1);
        }
        System.out.println("---------start----------");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("---------end----------");
        return map;
    }
}
