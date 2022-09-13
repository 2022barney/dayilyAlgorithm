package org.calm.May;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/20
 * @version: v1.0
 * ---------------------------
 */
public class Day0520 {
    public static void main(String[] args) {
        int[][] a = {{1,7},{2,6}, {3,5},{4,4},{5,4},{6,3},{7,2},{8,1}};
        int i = minimumLines(a);
        System.out.println(i);
    }

    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[][] clone = new int[len][2];
        for (int i = 0; i < len; i++) {
            int start = intervals[i][0];
            int[] arr = new int[2];
            arr[0] = start;
            arr[1] = i;
            clone[i] = arr;
        }
        int[] ans = new int[len];
        Arrays.sort(clone, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < len; i++) {
            int end = intervals[i][1];
            int l = 0;
            int r = len - 1;
            while (l < r) {
                int mid = l + r >> 1;
                int value = clone[mid][0];
                if (value >= end) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans[i] = intervals[r][0] >= intervals[i][1] ? clone[r][1] : -1;
        }
        return ans;
    }
    //[[36,9],[17,93],[34,4],[30,11],[11,41],[53,36],[5,92],[81,92],[28,36],[3,45],[72,33],[64,1],[4,70],[16,73],[99,20],[49,33],[47,74],[83,91]]
    public static int percentageLetter(String s, char letter) {
        int cnt = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == letter) {
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(len);
        double v = Double.valueOf(cnt) / Double.valueOf(len);
        System.out.println(v);
        return (int) (v * 100);
    }

    public  static  int minimumLines(int[][] stockPrices) {
        int cnt = 0;
        int pre = 0;
        int i = 0, j = 1;
        while (j < stockPrices.length) {
            int x1 = stockPrices[i][0];
            int y1 = stockPrices[i][1];
            int x2 = stockPrices[j][0];
            int y2 = stockPrices[j][1];
            double v = (double)(y2 - y1) / (double)(x2 - x1);
            if (  (int)v != pre) {
                cnt++;
            }
            pre = (int)v;
            i++;
            j++;
        }
        return cnt;
    }
}
