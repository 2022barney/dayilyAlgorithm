package org.calm.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/21
 * @version: v1.0
 * ---------------------------
 */
public class TheLeft {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 2, 3};
        lengthOfLIS(arr);
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        init.add(nums[0]);
        list.add(init);
        int max = 1;
        for (int i = 1; i < n; i++){
            List<Integer> pre = list.get(i - 1);
            List<Integer> cur = new ArrayList<>();
            if (nums[i] > nums[i - 1]) {
                cur.addAll(pre);
                cur.add(nums[i]);
            } else if (nums[i] == nums[i - 1]){
                cur.addAll(pre);
            } else {
                // 二分查找
                int l = 0, r = pre.size();
                while (l < r) {
                    int m = l + (r - l ) / 2;
                    if (pre.get(m) >= nums[i]) {
                        r = m - 1;
                    }else {
                        l = m;
                    }
                }

                if ( pre.get(l) < nums[i]) {
                    List<Integer> tmp = pre.subList(0, l + 1);
                    cur.addAll(tmp);
                }
                cur.add(nums[i]);
                if (cur.size() < pre.size()) {
                    cur = pre;
                }


            }

            max = Math.max(max, cur.size());
            list.add(cur);

        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("--------第 "+ i +"------");
            for (Integer integer : list.get(i)) {
                System.out.println(integer);
            }
            System.out.println("-------------------");
        }
        return max;

    }
}
