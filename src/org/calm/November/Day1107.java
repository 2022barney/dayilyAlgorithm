package org.calm.November;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------
 * 816. medium 模拟
 * ------------------------
 * @author liyang
 * @date 2022/11/7
 * @version 1.0
 * ------------------------
 */
public class Day1107 {
    String s;
    public List<String> ambiguousCoordinates(String _s) {
        s = _s.substring(1, _s.length() - 1);
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) { // 枚举逗号： 在i的后面追加逗号
            List<String> a = search(0, i), b = search(i + 1, n - 1);
            for (String x : a) {
                for (String y : b) {
                    ans.add("(" + x + ", " + y +")");
                }
            }
        }
        return ans;
    }

    List<String> search(int start, int end) {
        List<String> ans = new ArrayList<>();
        if (start == end || s.charAt(start) != '0') {
            ans.add(s.substring(start, end + 1));
        }
        for (int i = start; i < end; i++) {
            // 枚举小数点： 在i后面追加小数点
            String a = s.substring(start, i + 1), b = s.substring(i + 1, end + 1);
            if (a.length() > 1 && a.charAt(0) == '0') continue;
            if (b.charAt(b.length() - 1) == '0') continue;
            ans.add(a + "." + b);
        }
        return ans;
    }
}
