package org.calm.june;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/19
 * @version: v1.0
 * ---------------------------
 */
public class Test19 {
    public static void main(String[] args) {
        longestSubsequence("1001010", 5)    ;
    }
    public static int longestSubsequence(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[][] tmp = new int[n][2];
        tmp[0] = new int[]{cs[n - 1] == '1' ? 1 : 0,cs[n - 1] == '1' ? 0 : 1 };
        int zeroNum = cs[n - 1] == '1' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            char c = cs[i];
            int curValue = (int)Math.pow(2, i);
            tmp[i] = new int[]{tmp[i + 1][0] + curValue,tmp[i + 1][1] + c == '1' ? 0 : 1 };
            if (c == '0') {
                zeroNum++;
            }
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (tmp[l][0] > k) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        System.out.println(zeroNum);
        System.out.println(l);
       for (int i = 0; i < n; i ++){
            System.out.println("tmp : " + tmp[i][0] +"  tmp2: " + tmp[i][1]);
        }
        return zeroNum - (int)tmp[l][1] + n - l;
    }
}
