package org.calm.june;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/28
 * @version: v1.0
 * ---------------------------
 */
public class Day0628_2 {
    //
    public static void main(String[] args) {
        String str= " ";
        //System.out.println(str.charAt(0) == ' ');
        System.out.println(strToInt(" -42"));
    }

    public static int strToInt(String str) {
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        int i = 0, j =  0;
        long sum = 0;
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        System.out.println("111: " + i);
        if (!(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) >= '0' || str.charAt(i) <= '9')) {
            return 0;
        }
        if (str.charAt(i) == '-') {
            flag = false;
        }
        if (i == n) {
            return 0;
        }
        j = i;
        while (str.charAt(j) == '0') {
            j++;
        }
        System.out.println(j);
        while (j < n && str.charAt(j) >= '0' && str.charAt(j) <= '9' ) {
            sum = sum * 10 + Integer.parseInt(str.charAt(j) + "");
            System.out.println(sum);

            if (flag && sum > Integer.MAX_VALUE) {
                return 0;
            }
            if (!flag && -sum < Integer.MIN_VALUE) {
                return 0;
            }
            sb.append(str.charAt(j));
            j++;
        }
        if (sb.length() > 0) {
            return (int)sum;
        } else {
            return 0;
        }
    }

}
