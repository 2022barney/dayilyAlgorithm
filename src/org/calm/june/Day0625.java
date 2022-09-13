package org.calm.june;

import java.util.*;


public class Day0625 {

    public List<Integer> orderNo(int n, int m, int[][] grid) {
        List<Integer> ans = new ArrayList<Integer>(m);

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            tm.put(grid[i][0] + 2 * (grid[i][1] - 1), i );
        }

        Iterator<Map.Entry<Integer, Integer>> it = tm.entrySet().iterator();

        int j = 0;
        while (it.hasNext() && j < m) {
            Map.Entry<Integer, Integer> next = it.next();
            ans.add(next.getValue());
        }

        return ans;


    }
}
/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/25
 * @version: v1.0
 * ---------------------------
 */