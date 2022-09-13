package org.calm.july;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

/**
 * ---------------------------
 * 
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/6
 * @version: v1.0
 * ---------------------------
 */
public class Day0706 {

    public int maxFrequency(int[] nums, int k) {
        // 前缀和 + 二分
        // 1, 2, 3, 4, 9, 9
        // 2
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }


        return 0;

    }

    public static void main(String[] args) {

        Date now = new Date();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(now);
        c1.add(Calendar.YEAR, 1);
        System.out.println(c1.getTime());

        long d = 1000;
        BigDecimal bigDecimal = new BigDecimal(d);

        BigDecimal divide = bigDecimal.divide(new BigDecimal(365), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);
        BigDecimal multiply = divide.multiply(new BigDecimal(2L));
        System.out.println(multiply);


    }
}
