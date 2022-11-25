package org.calm.WeedendContest.Contest320;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * ------------------------
 * <p>
 * ------------------------
 * @author liyang
 * @version 1.0
 * @date 2022/11/20
 * ------------------------
 */
public class Day1120_3 {

    long ans;
    public long minimumFuelCost(int[][] roads, int seats) {
        List<Integer>[] adj;
        int s = 0;
        if (roads == null || roads.length == 0) return 0;
        int n = roads.length;
        adj = new List[n + 1];
        s = seats;
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] road : roads){
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }
        for (int x : adj[0]) {
            dfs(x, 0, adj, s);
        }

        return ans;

    }

    int dfs(int x, int p, List<Integer>[] adj, int s) {
        int size = 1;
        for (int y : adj[x]) {
            if (y != p) {
                size += dfs(y, x, adj, s);
            }
        }
        ans += (size + s - 1) / s;
        return size;
    }
}
