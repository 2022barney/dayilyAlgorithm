package org.calm.graphTheory;

import java.util.*;

/**
 * ------------------------
 * 1466. medium
 * ------------------------
 * @author liyang
 * @date 2022/11/10
 * @version 1.0
 * ------------------------
 */
public class Day1110_2 {
    // 时间复杂度O(n)
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] adjacentArr = new List[n];

        for (int i = 0; i < n; i++) {
            adjacentArr[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            adjacentArr[connection[0]].add(connection[1]);
            adjacentArr[connection[1]].add(connection[0]);

        }

        int[] levels = new int[n];
        Arrays.fill(levels, -1);

        levels[0] = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(0);

        while (!queue.isEmpty()) {
            int city = queue.poll();
            List<Integer> adjacent = adjacentArr[city];
            for (int next : adjacent) {
                if (levels[next] < 0) {
                    levels[next] = levels[city] + 1;
                    queue.offer(next);
                }
            }
        }
        int reorder = 0;
        for (int[] connection : connections) {
            if (levels[connection[0]] < levels[connection[1]]) {
                reorder++;
            }
        }
        return reorder;

    }
}
