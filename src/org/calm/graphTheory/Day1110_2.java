package org.calm.graphTheory;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------
 * 802.medium
 * ------------------------
 * @author liyang
 * @date 2022/11/9
 * @version 1.0
 * ------------------------
 */
public class Day1110_2 {

    /**
     * 白色（用 000 表示）：该节点尚未被访问；
     * 灰色（用 111 表示）：该节点位于递归栈中，或者在某个环上；
     * 黑色（用 222 表示）：该节点搜索完毕，是一个安全节点。
     * 时间复杂度：O(n+m).其中 n 是图中的点数，m 是图中的边数。
     * 空间复杂度：O(n)。存储节点颜色以及递归栈的开销均为 O(n)
     * @param graph
     * @return
     */

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (safe(graph, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) {
            return color[x] == 2;
        }

        color[x] = 1;

        for (int y : graph[x]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }
}
