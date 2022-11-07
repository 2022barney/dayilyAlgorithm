package org.calm.graphTheory;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ------------------------
 *841.medium
 * ------------------------
 * @author liyang
 * @date 2022/11/7
 * @version 1.0
 * ------------------------
 */
public class Day1107_2 {
    // bfs
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        vis[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            num++;
            for (int it : rooms.get(x)) {
                if (!vis[it]) {
                    vis[it] = true;
                    queue.offer(it);
                }
            }
        }
        return num == n;
    }
}

