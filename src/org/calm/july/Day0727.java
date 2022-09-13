package org.calm.july;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/27
 * @version: v1.0
 * ---------------------------
 */
public class Day0727 {
    public static void main(String[] args) {
        int bit = 1 << -1;
        System.out.println(bit);
        String a = "1";
        System.out.println(a.substring(0, 1));
        String s = fractionAddition("4/5");
        System.out.println(s);
    }
    public static String fractionAddition(String expression) {
        if (expression.length() < 7) {
            return expression;
        }
        int nu = 0, de = 1;
        int i = 0;
        int n = expression.length();
        while (i < n - 3) {
            int t = 1;
            if (expression.charAt(i) == '-') {
                t = -1;
            }
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                i++;
            }
            int j = i;
            while (j < n && '0' <= expression.charAt(j) && expression.charAt(j) <= '9') {
                j++;
            }
            int a = Integer.parseInt(expression.substring(i, j));
            i = ++j;
            while (j < n && '0' <= expression.charAt(j) && expression.charAt(j) <= '9') {
                j++;
            }
            int b = Integer.parseInt(expression.substring(i, j) + "");

            nu =  b * nu  + t * a * de;
            de =  de * b;
            if (nu == 0) de = 1;
            i = j;
        }
        System.out.println("nu" + nu);
        System.out.println("de" + de);

        StringBuilder sb = new StringBuilder();

        int gcd = gcd(Math.abs(de), Math.abs(nu));
        if (gcd == 0) {
            return sb.append("0/1").toString();
        }
        if (nu < 0) {
            sb.append("-");
        }
        nu = Math.abs(nu) / gcd;
        de = de / gcd;
        return sb.append(nu).append("/").append(de).toString();


    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
