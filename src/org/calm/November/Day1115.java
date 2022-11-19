package org.calm.November;


import java.util.Arrays;

/**
 * ------------------------
 * 1710.easy
 * ------------------------
 * @author liyang
 * @date 2022/11/15
 * @version 1.0
 * ------------------------
 */
public class Day1115 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxNum = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int[] box : boxTypes) {
            int boxNum = box[1];
            int boxCnt = box[0];
            if (truckSize >= boxCnt) {
                truckSize -= boxCnt;
                maxNum += boxCnt * boxNum;
            } else {
                maxNum += truckSize * boxNum;
                break;
            }
        }
        return maxNum;
    }
}
