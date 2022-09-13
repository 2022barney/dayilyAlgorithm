package org.calm.May;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/13
 * @version: v1.0
 * ---------------------------
 */
public class Day0513 {
    public static void main(String[] args) {
        String first = "intention";
        String second = "execution";
        boolean b = oneEditAway(first, second);
        System.out.println(b);

    }


    public static boolean oneEditAway(String first, String second) {
        boolean flag = false;
        int m = first.length();
        int n = second.length();
        StringBuilder sb1 = new StringBuilder(first);
        StringBuilder sb2 = new StringBuilder(second);
        if("".equals(first) && "".equals(second)) return true;
        if (m == 0 && n == 1 || m == 1 && n == 0) return true;
        if(Math.abs(m - n) > 1) return flag;
        int min = Math.min(m, n);
        for (int i = 0; i < min; i++) {
            char c1 = first.charAt(i);
            char c2 = second.charAt(i);
            if (c1 != c2) {
                StringBuilder t1 = new StringBuilder(sb1);
                StringBuilder t2 = new StringBuilder(sb1);
                StringBuilder t3 = new StringBuilder(sb1);
                t1 = t1.insert(i + 1, c2);
                t2 = t2.deleteCharAt(i);
                t3 = t3.deleteCharAt(i).insert(i, c2);
                if (!t1.toString().equals(second) && !t2.toString().equals(second)
                        && !t3.toString().equals(second)) {
                    break;
                }
            } else {
                if (i == min - 1) {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
