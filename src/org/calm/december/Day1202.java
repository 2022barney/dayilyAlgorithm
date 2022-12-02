package org.calm.december;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ------------------------
 *1769。medium 模拟
 * ------------------------
 * @author liyang
 * @date 2022/12/2
 * @version 1.0
 * ------------------------
 */
public class Day1202 {
    public static void main(String[] args) {
        minOperations("001011");
    }

    public static int[] minOperations(String boxes) {

        int n = boxes.length();
        int[] ans = new int[n];
        int step = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            step += cnt;
            ans[i] += step;
            if (boxes.charAt(i) == '1') cnt++;
        }

        step = 0; cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            step += cnt;
            ans[i] += step;
            if (boxes.charAt(i) == '1') cnt++;
        }
        return ans;
    }
}
