package org.calm.May;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/24
 * @version: v1.0
 * ---------------------------
 */
public class Day0524 {
    public static void main(String[] args) {
        myPow(0.00001
                ,3);
    }

    static double t;
    public static double myPow(double x, int n) {
        int a = Math.abs(n);
        t = x;
        if (n == 0) return 1;
        double y = x;
        double res = dfs(x, y,a);
        return n > 0 ? res : 1.0 / res;
    }

    private static double dfs(double x, double y, int a) {
        if (--a == 0) {
            return x;
        }

        t *= x;

        return t;
    }
}
