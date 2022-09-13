package org.calm.September;

/**
 * ---------------------------
 *
 * ---------------------------
 * @author: liyang
 * @date: 2022/9/1
 * @version: v1.0
 * ---------------------------
 */
public class Day1 {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int flag = -1;
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    flag = prices[j];
                    break;
                }
            }
            int x = flag == -1 ? 0 : flag;
            ans[i] = prices[i] - x;
        }
        return ans;
    }

}
