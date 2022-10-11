package org.calm.October;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/10/11
 * @version 1.0
 * ------------------------
 */
public class Day1011 {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Character> l1 = new ArrayList<>();
        List<Character> l2 = new ArrayList<>();

        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                l1.add(c1);
                l2.add(c2);
            }
        }
        if (l1.size() == 0) {
            return true;
        }
        if (l1.size() == 2) {
            if (l1.get(0) == l2.get(1) && l1.get(1) == l2.get(0)) {
                return true;
            }
        }
        return false;
    }
}
