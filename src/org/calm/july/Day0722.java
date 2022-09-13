package org.calm.july;

import org.calm.May.ZsBidOpeningInfoVo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/22
 * @version: v1.0
 * ---------------------------
 */
public class Day0722 {

    public static void main(String[] args) {
        List<ZsBidOpeningInfoVo> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        System.out.printf("aaa : %x",Integer.parseInt("10000", 2));
        //[1,3], [1,4], [2,5], [3,5]
        //[1,3], [3,4], [2,6]
        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        int test = test(intervals);
        System.out.println(test);
    }

    public static int test(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int a = -1, b = -1;
        int ans = 0;
        for (int[] ints : intervals) {
            if (ints[0] > b) {
                ans += 2;
                b = ints[1];
                a = ints[1] - 1;
            } else if (a < ints[0] && b <= ints[1]) {
                ans++;
                b = ints[1];
                a = ints[1] - 1;
            }
        }
        return ans;
    }
}
