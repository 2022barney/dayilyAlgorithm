package org.calm.May;

import java.util.ArrayList;
import java.util.List;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/29
 * @version: v1.0
 * ---------------------------
 */
public class Day0529 {
    public static void main(String[] args) {
        String sentence = "$76111 ab $6 $";

        int discount = 48;
        String s = discountPrices(sentence, discount);
        System.out.println(s);
    }

    public static String discountPrices(String sentence, int discount) {
        String nums = "0123456789";
        String[] s = sentence.split(" ");
        String res = new String();
        out:for (String s1 : s) {
            String sb = new String();
            if (s1.charAt(0) != '$' ) {
                sb = s1 + " ";
            } else {
                for (int i = 1; i < s1.length(); i++) {
                    if (nums.indexOf(s1.charAt(i)) == -1) {
                        sb = s1 + " ";
                        res += sb;
                        continue out;
                    }
                    sb += s1.charAt(i);
                }
                double preValue = Double.valueOf(sb)  * (1 - discount / 100.00);
                sb = "$" + String.format("%.2f",  preValue ) + " ";

            }
            res += sb;
            res.split("\\.", -1);
        }
        return res.trim();
    }


}
