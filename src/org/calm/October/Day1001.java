package org.calm.October;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/10/1
 * @version 1.0
 * ------------------------
 */
public class Day1001 {
    public boolean equalFrequency(String word) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, List<Character>> mm = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0));
        }
        List<Integer> tmp = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            List<Character> list = mm.getOrDefault(entry.getValue(), new ArrayList<>());
            list.add(entry.getKey());
            mm.put(entry.getValue(), list);
            tmp.add(entry.getValue());
        }


        if (mm.size() == 1 && mm.get(1).size() != 0) return true;

        if (mm.size() > 2) return false;
        int a = tmp.get(0), b = tmp.get(1);
        boolean f1 = Math.abs(a - b) == 1;
        boolean f2 = mm.get(a).size() == 1 || mm.get(b).size() == 1;
        return  f1 && f2;

    }
}
