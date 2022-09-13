package org.calm.july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/29
 * @version: v1.0
 * ---------------------------
 */
public class Day0729_2 {

    public static void main(String[] args) {
        int i = numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0});
        System.out.println(i);
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (informTime[headID] == 0) return 0;
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] == headID) {
                list.add(i);
            }
        }

        for (int i : list) {
            ans += numOfMinutes(n, i, manager, informTime);
        }
        ans += informTime[headID];
        return ans;
    }


    class Solution {
        private int ans = 0;

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < manager.length; i++) {
                graph.put(i,new ArrayList<>());
            }

            for (int i = 0; i < manager.length; i++) {
                if(manager[i]!=-1){
                    graph.get(manager[i]).add(i);
                }
            }

            dfs(graph,headID,informTime,0);
            return ans;
        }

        private void dfs(Map<Integer, List<Integer>> graph, int pos, final int[] informTime, int step){

            for (int next : graph.get(pos)) {
                dfs(graph,next,informTime,step+informTime[pos]);
            }
            ans = Math.max(step,ans);
        }
    }



}
