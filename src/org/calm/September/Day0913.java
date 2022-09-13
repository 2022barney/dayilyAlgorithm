package org.calm.September;

import java.util.Arrays;
import java.util.Collections;

/**
 * ---------------------------
 * 670.medium
 * ---------------------------
 * @author liyang
 * @date 2022/9/13
 * @version v1.0
 * ---------------------------
 */
public class Day0913 {

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
    }

    /**
     * 2736 17738
     * @param num
     * @return
     */
    public static int maximumSwap(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        Integer[] arr = new Integer[n];
        Integer[] sortArr = new Integer[n];

        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(str.charAt(i)+"");
            arr[i] = cur;
            sortArr[i] = cur;
        }

        Arrays.sort(sortArr, Collections.reverseOrder());
        boolean flag = true;
        int a = 0;
        int b = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (!arr[i].equals(sortArr[i])) {
                flag = false;
                a = arr[i];
                b = sortArr[i];
                arr[i] = b;
                idx = i + 1;
                break;
            }
        }
        if (flag) {
            return num;
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] == b) {
                    arr[i] = a;
                    break;
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = ans * 10 + arr[i];
            }
            return ans;
        }
    }
}
