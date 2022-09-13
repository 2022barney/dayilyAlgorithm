package org.calm.july;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ---------------------------
 * 676. medium
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/11
 * @version: v1.0
 * ---------------------------
 */
public class Day0711 {
    public static void main(String[] args) {
        Day0711 d = new Day0711();
        d.buildDict(new String[]{"hello"});
        d.search("hhllo");
    }

    Map<Integer, List<String>> map;
    public Day0711() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for(String str : dictionary) {
            int length = str.length();
            List<String> list = map.getOrDefault(length, new ArrayList<String>());
            if (!list.contains(str)) {
                list.add(str);
            }
            map.put(length, list);
        }
    }

    public boolean search(String searchWord) {
        int length = searchWord.length();
        List<String> list = map.get(length);
        if (list == null || list.size() == 0) {
            return false;
        } else {
            for (String str : list) {
                int cnt = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (cnt > 1) {
                        break;
                    }
                    if (searchWord.charAt(i) != str.charAt(i)) {
                        cnt++;
                    }
                }
                if (cnt == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
