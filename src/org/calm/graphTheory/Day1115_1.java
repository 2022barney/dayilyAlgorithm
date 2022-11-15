package org.calm.graphTheory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * ------------------------
 *886. medium 可能的二分法
 * ------------------------
 * @author liyang
 * @date 2022/11/15
 * @version 1.0
 * ------------------------
 */
public class Day1115_1 {
    // 时间复杂度：O(n + m) n人数，m为数组大小
    // 空间复杂度同
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            g[dislike[0]].add(dislike[1]);
            g[dislike[1]].add(dislike[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    int t = queue.poll();
                    for (int next : g[t]) {
                        if (color[next] > 0 && color[next] == color[t]) {
                            return false;
                        }
                        if (color[next] == 0) {
                            color[next] = 3 ^ color[t];
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return true;
    }
}
