package org.calm.binarySearch;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/4
 * @version: v1.0
 * ---------------------------
 */
public class Flower {

    // [1,10,3,10,2]
    // 3
    // 1
    public static void main(String[] args) {
        minDays(new int[]{1, 10, 3, 10, 2}, 3, 1);
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int r = 0;
        for (int i = 0; i < n; i++) {
            r = Math.max(r, bloomDay[i]);
        }
        int l = 0;
        r = r + 1;
        while (l + 1 != r) {
            int c = l + r >> 1;
            if(check(c, bloomDay, m, k)) {
                r = c;
            }else {
                l = c;
            }
        }
        return r;
    }

    static boolean check(int c, int[] bloomDay, int m, int k) {
        int cnt = 0;
        int length = 0;
        boolean flag = false;
        for(int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] > c) {
                if(flag) {
                    int cur =  length / k;
                    cnt += cur;
                    length = 0;
                }
                flag = false;
            } else {
                flag = true;
                length++;
            }
        }
        cnt += length / k;
        System.out.println(cnt);
        return  cnt >= m;
    }

}
