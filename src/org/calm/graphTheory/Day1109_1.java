package org.calm.graphTheory;

import java.util.*;

/**
 * ------------------------
 * 1376.medium 通知所有员工耗时
 * ------------------------
 * @author liyang
 * @date 2022/11/9
 * @version 1.0
 * ------------------------
 */
public class Day1109_1 {

    // bfs
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Queue<int[]> queue = new LinkedList<>();
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                list[manager[i]].add(i);
            }
        }

        queue.offer(new int[]{headID, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curIdx = cur[0], time = cur[1];
            res = Math.max(res, time);
            List<Integer> curList = list[curIdx];
            for (Integer integer : curList) {
                queue.offer(new int[]{integer, time + informTime[curIdx]});
            }
        }
        return res;
    }
}
