package org.calm.October;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------
 * 1441.medium
 * ------------------------
 * @author liyang
 * @date 2022/10/25
 * @version 1.0
 * ------------------------
 */
public class Day1015 {

    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int m = target.length;
        // [1, 3]
        // 3
        int start = 1;
        for (int i = 0; i < m;) {
            ans.add("Push");
            if (start < target[i]) {
                ans.add("Pop");
            } else {
                i++;
            }
            start++;
        }
        return ans;
    }
}


