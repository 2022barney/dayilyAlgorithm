package org.calm.graphTheory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ------------------------
 *847。hard
 * ------------------------
 * @author liyang
 * @date 2022/11/11
 * @version 1.0
 * ------------------------
 */
public class Day1111_1 {

    // bfs

    /**
     *     时间复杂度O(n^2 * 2^n) 常规bfs复杂度：O(m + n)  n点的个数，m边的个数，本题引入mask， 范围[0, 2^n)
     *     因此看成是进行了2^n次常规的bfs，由于m没有明显给出，最坏情况下为完全图，有m = O(n^2)
     *
     *     空间复杂度：O(n * 2^n), 队列所需空间
      */

    public int shortestPathLength(int[][] graph) {

        int m = graph.length;
        boolean[][] seen = new boolean[m][1 << m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int v = cur[0], mask = cur[1], dist = cur[2];

            if (((1 << m) - 1) == mask) {
                return dist;
            }

            for (int u : graph[v]) {
                int maskU = mask | (1 << u);
                if (!seen[u][maskU]) {
                    seen[u][maskU] = true;
                    queue.offer(new int[]{u, maskU, dist + 1});
                }
            }
        }
        return -1;
    }
}
