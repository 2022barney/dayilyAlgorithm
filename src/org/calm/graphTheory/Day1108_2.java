package org.calm.graphTheory;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------
 *1319.medium  连通分量
 * ------------------------
 * @author liyang
 * @date 2022/11/8
 * @version 1.0
 * ------------------------
 */
public class Day1108_2 {

    List<Integer>[] edges;
    boolean[] used;
    // ans： 连通分量个数 - 1， 前提 边数 大于 n - 1
    // 时间复杂度: O(n + m) m 是connections 长度
    // 空间复杂度: O(m + n) ,其中 O(m) 为存储所有边需要的空间
    // O(n)为深度优先搜索中使用的栈空间
    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        edges = new List[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] conn : connections) {
            edges[conn[0]].add(conn[1]);
            edges[conn[1]].add(conn[0]);
        }

        used = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                dfs(i);
                ans++;
            }
        }
        return ans - 1;
    }

    void dfs(int u) {
        used[u] = true;
        for (int v : edges[u]) {
            if (!used[v]) {
                dfs(v);
            }
        }
    }

}
