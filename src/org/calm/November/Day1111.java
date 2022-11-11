package org.calm.November;

import java.util.ArrayList;

/**
 * ------------------------
 *1704. easy
 * ------------------------
 * @author liyang
 * @date 2022/11/11
 * @version 1.0
 * ------------------------
 */
public class Day1111 {

    public boolean halvesAreAlike(String s) {
        String meta = "aeiouAEIOU";
        int n = s.length();
        String a = s.substring(0, n / 2);
        String b = s.substring(n/2);

        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n/2; i++) {
            if (meta.indexOf(a.charAt(i)) > -1) {
                cnt1++;
            }
            if (meta.indexOf(b.charAt(i)) > -1) {
                cnt2++;
            }
        }
        return cnt1 == cnt2;
    }
}
