package org.calm.binarySearch;

import java.util.Arrays;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/23
 * @version: v1.0
 * ---------------------------
 */
public class TwoSum2 {
    //[10,2,5,3]
    //[-10,12,-20,-8,15]
    //-20. -10, -8, 12, 15
    //[102,-592,457,802,98,-132,883,356,-857,461,-453,522,250,476,991,540,-852,-485,-637,999,-803,-691,-880,881,-584,750,-124,745,-909,-892,304,-814,868,665,50,-40,26,-242,-797,-360,-918,-741,88,-933,-93,360,-738,833,-191,563,449,840,806,-87,-950,508,74,-448,-815,-488,639,-334]
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            int l = i + 1, r = n - 1;
            int t1 = 2 * arr[i];
            int t2 =  arr[i] / 2;
            if (arr[i] % 2 == 0) {
                if (check(l, r, arr, t2)) {
                    return true;
                }
            }

            if (check(l, r, arr, t1) ) {
                return true;
            }
        }
        return false;
    }
    boolean  check(int l, int r, int[] arr, int target) {

        while (l <= r) {
            int m = l + r >> 1;
            if (arr[m] == target) {
                return true;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
