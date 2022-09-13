package org.calm.july;

import java.util.Arrays;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/2
 * @version: v1.0
 * ---------------------------
 */
public class Day0702 {
    public static void main(String[] args) {
        int a = 83 - 15 + 457 - 390 + 159 + 390 - 679 + 301 + 679;
        System.out.println(a);
        int b = 1000 - 230;
        System.out.println(b);
        Arrays.stream(new int[]{12}).max().getAsInt();
        int target =100;
        int stratFuel =25;
        int[][] arr =   new int[][]{{25,25},{50,25},{75,25}};
        int i = minRefuelStops(target, stratFuel, arr);
        System.out.println(i);
    }
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;


        int ans = 0;
        int curFuel = startFuel;
        int curIdx = 0;
        int canGetMost = 0;
        int pre = -1;
        int preIdx = 0;
        while(curFuel < (target - curIdx)) {
            int l = pre, r = stations.length;


            while(l + 1 != r) {
                int m = l + (r - l) / 2 ;
                if (stations[m][0] - preIdx <= curFuel) {
                    int t = curFuel - stations[m][0] + preIdx + stations[m][1];
                    if (t >= canGetMost) {
                        canGetMost = t;
                        curIdx = stations[m][0];
                    }
                    l = m;
                } else {
                    r = m;
                }
            }
            if (l == -1) {
                return -1;
            }
            pre = l;
            curFuel = canGetMost;
            preIdx = curIdx;
            if((l + 1) == stations.length && curFuel + stations[l][1] < target) return -1;
            ans++;
        }
        return ans;
    }
}
