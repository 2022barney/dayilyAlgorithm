package org.calm.November;

import sun.security.action.GetBooleanAction;

import java.security.AccessController;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/11/15
 * @version 1.0
 * ------------------------
 */
public class Day1115 {

    public static void main(String[] args) {
        boolean b = AccessController.doPrivileged(
                new GetBooleanAction(
                        "java.util.Arrays.useLegacyMergeSort")).booleanValue();
        System.out.println(b);
    }
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
