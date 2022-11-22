package org.calm.graphTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * ------------------------
 *1615.medium 最大城市秩
 * ------------------------
 * @author liyang
 * @date 2022/11/21
 * @version 1.0
 * ------------------------
 */
public class Day1121 {
    public int maximalNetworkRank(int n, int[][] roads) {
        TreeSet<Integer>[] edges = new TreeSet[n];
        int[] indeg = new int[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new TreeSet<>();
        }
        for (int[] road : roads) {
            edges[road[0]].add(road[1]);
            edges[road[1]].add(road[0]);
            ++indeg[road[0]];
            ++indeg[road[1]];
        }

        int first = -1, second = -2;
        for (int i = 0; i < n; i++) {
            if (indeg[i] > first) {
                second = first;
                first = indeg[i];
            }
            else if (indeg[i] > second) {
                second = indeg[i];
            }
        }

        List<Integer> firstList = new ArrayList<>(), secondList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indeg[i] == first) {
                firstList.add(i);
            }
            else if (indeg[i] == second) {
                secondList.add(i);
            }
        }

        if (firstList.size() == 1) {
            int u = firstList.get(0);
            for (int v : secondList) {
                if (!edges[u].contains(v)) {
                    return first + second;
                }
            }
            return first + second - 1;
        }
        else {
            int m = roads.length;
            if (firstList.size() * (firstList.size() - 1) / 2 > m) {
                return first * 2;
            }
            for (int u : firstList) {
                for (int v : firstList) {
                    if (u != v && !edges[u].contains(v)) {
                        return first * 2;
                    }
                }
            }
            return first * 2 - 1;
        }
    }
}