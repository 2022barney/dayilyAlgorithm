package org.calm.june;

import java.util.TreeMap;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/13
 * @version: v1.0
 * ---------------------------
 */
public class Day0613 {
    public static void main(String[] args) {
        var a = "123";
        var t = "123";
        TreeMap<Object, Object> map = new TreeMap<>();

        System.out.println(a);
        TreeMap<Object, Object> ma = new TreeMap<>();
    }
    public int heightChecker(int[] heights) {
        int[] cnts = new int[110];
        int n = heights.length;
        for (int height : heights) {
            cnts[height]++;
        }
        int[] t = new int[n];
        for (int i = 0, j = 0; i < cnts.length; i++) {
            while (cnts[i]-- > 0){
                t[j++] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }

}
