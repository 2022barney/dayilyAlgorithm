package org.calm.binarySearch;

import java.util.*;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/8
 * @version: v1.0
 * ---------------------------
 */
public class RightInterval {

    public int[] findRightInterval(int[][] intervals) {
        int m = intervals.length, n = intervals[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] cur = new int[2];
            cur[0] = intervals[i][0];
            cur[1] = i;
            list.add(cur);
        }
        //[[3,4],[2,3],[1,2]]
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        int[] ans = new int[m];
        int i = 0;
        for (int[] arr : intervals) {
            int t = arr[1];
            int l = -1, r = m;
            while (l + 1 != r) {
                int c = (r - l) / 2 + l;
                int[] ints = list.get(c);
                if (ints[0] < t) {
                    l = m;
                } else {
                    r = m;
                }
            }
            if (r != -1 && r != m) {
                ans[i++] = list.get(r)[1];
            } else {
                ans[i++]= -1;
            }
        }
        return ans;
    }
}
