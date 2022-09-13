package org.calm.May;

import java.util.Arrays;

/**
 * ---------------------------
 *
 * ---------------------------
 * @author: liyang
 * @date: 2022/5/17
 * @version: v1.0
 * ---------------------------
 */
public class Day0517 {
    public static void main(String[] args) {

        String[] arr = new String[]{"A", "B"};
        String[] clone = arr.clone();
    }

    public static boolean isAlienSorted(String[] words, String order) {
        boolean flag = true;
        int length = words.length;
        out:for (int i = 1; i < length; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            int m = 0, n = 0;
            int preLength = pre.length();
            int curLength = cur.length();
            while (m < preLength && n < curLength) {
                Character cPre = pre.charAt(m);
                Character cCur = cur.charAt(n);
                if (order.indexOf(cPre) < order.indexOf(cCur)) {
                    return false;
                } else if (order.indexOf(cPre) > order.indexOf(cCur)) {
                    continue out;
                } else {
                    m++;
                    n++;
                    if (m == preLength && n < curLength) {
                        return false;
                    }
                }
            }
        }
        return flag;
    }
}
