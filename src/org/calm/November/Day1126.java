package org.calm.November;

import java.util.*;

/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/11/26
 * @version 1.0
 * ------------------------
 */
public class Day1126 {
    public static void main(String[] args) {
        int[][] edges = {{0,3,4},{3,4,0},{1,3,0},{2,4,4},{2,3,0}};
        int maxMoves = 6;
        int n = 3;
        int i = reachableNodes(edges, maxMoves, n);
        int j = reachableNodes2(edges, maxMoves, n);
        System.out.println(i);
        System.out.println(j);

        var pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 1});
        pq.add(new int[]{0, 3});
        int i1 = pq.peek()[1];
        System.out.println(i1);
    }
    public static int reachableNodes(int[][] edges, int maxMoves, int n) {
        int s = 0;
        for (int[] edge : edges) {
            s += edge[2];
        }
        List<Integer>[] adjacency = new List[n + s];
        for (int i = 0; i < adjacency.length; i++) {
            adjacency[i] = new ArrayList<>();
        }
        int start = n;
        for (int[] edge : edges) {

            int len = edge[2];
            if (len == 0) {
                adjacency[edge[0]].add(edge[1]);
                adjacency[edge[1]].add(edge[0]);
                continue;
            }
            adjacency[start].add(edge[0]);
            adjacency[edge[0]].add(start);
            adjacency[start + len - 1].add(edge[1]);
            adjacency[edge[1]].add(start + len - 1);
            for (int i = start; i < start + len - 1; i++) {
                adjacency[i].add(i+1);
            }
            for (int i = start + len - 1; i > start; i--) {
                adjacency[i].add(i - 1);
            }
            start = start + len;
        }
        boolean[] visited = new boolean[n + s];
        visited[0] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        int ans = 1;
        while (!queue.isEmpty() && maxMoves > 0) {
            maxMoves--;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                for (int x : adjacency[cur]) {
                    if (!visited[x]) {
                        visited[x] = true;
                        queue.add(x);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    static boolean[] visited;
    static int ans = 1;
    public static int reachableNodes2(int[][] edges, int maxMoves, int n) {
        int s = 0;
        for (int[] edge : edges) {
            s += edge[2];
        }
        List<Integer>[] adjacency = new List[n + s];
        for (int i = 0; i < adjacency.length; i++) {
            adjacency[i] = new ArrayList<>();
        }
        int start = n;
        for (int[] edge : edges) {

            int len = edge[2];
            if (len == 0) {
                adjacency[edge[0]].add(edge[1]);
                adjacency[edge[1]].add(edge[0]);
                continue;
            }
            adjacency[start].add(edge[0]);
            adjacency[edge[0]].add(start);
            adjacency[start + len - 1].add(edge[1]);
            adjacency[edge[1]].add(start + len - 1);
            for (int i = start; i < start + len - 1; i++) {
                adjacency[i].add(i + 1);
            }
            for (int i = start + len - 1; i > start; i--) {
                adjacency[i].add(i - 1);
            }
            start = start + len;
        }
        visited = new boolean[n + s];
        visited[0] = true;
        for (int x : adjacency[0]) {
            dfs(x, visited, maxMoves, adjacency);
        }
        return ans;
    }

    static void dfs(int x, boolean[] visited, int maxMoves, List<Integer>[] adjacency) {
        if (maxMoves <= 0) return;
        for (int y : adjacency[x]) {
            if (!visited[y]) {
                ans++;
                visited[y] = true;
                dfs(y, visited, maxMoves - 1, adjacency);
            }
        }
    }

    /**
     *  朴素dijkstra        时间复杂度O(n^2)
     * @param edges
     * @param maxMoves
     * @param n
     * @return
     */
    public static int reachableNodes3(int[][] edges, int maxMoves, int n) {

        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] edge : edges) {
            g[edge[0]][edge[1]] = edge[2] + 1;
        }
        boolean[] st = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            st[t] = true;
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
        int ans = 0;
        for (int d : dist) {
            if (d <= maxMoves) ans++;
        }

        for (int[] edge : edges) {
            int a = Math.max(0, maxMoves - dist[edge[0]]);
            int b = Math.max(0, maxMoves - dist[edge[1]]);
            ans += Math.min(edge[2], a + b);
        }
        return ans;
    }
}
