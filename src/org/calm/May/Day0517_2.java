package org.calm.May;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/17
 * @version: v1.0
 * ---------------------------
 */
public class Day0517_2 {
    public static void main(String[] args) {
        String str = "?3295???";
        System.out.println(sumGame(str));;
    }
    public static boolean sumGame(String num) {
        int sum1 = 0;
        int sum2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        int l = num.length();
        for (int i = 0; i < l/2; i++) {
            int i1 = num.charAt(i) == '?' ? 0 : Integer.parseInt(String.valueOf(num.charAt(i)));
            sum1 += i1;
            cnt1 += num.charAt(i) == '?' ? 1 : 0;
        }
        for (int i = l/2; i < l; i++) {
            int t =  num.charAt(i) == '?' ? 0 : Integer.parseInt(String.valueOf(num.charAt(i)));
            sum2 += t;
            cnt2 += num.charAt(i) == '?' ? 1 : 0;
        }
        System.out.printf("%s %s", cnt1, cnt2);
        if ((cnt1 + cnt2) % 2 != 0) {
            return true;
        }

        return 9 * (cnt1 - cnt2) / 2 + sum1 - sum2 != 0;

    }
}
