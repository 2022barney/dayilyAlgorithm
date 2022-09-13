package org.calm.binarySearch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/30
 * @version: v1.0
 * ---------------------------
 */
public class TestNoExist {

    // 06.30暂时总结一下：
    // 查找最左侧时，若没有相等的，则查找到第一个大于目标值的数，查找右侧则相反，查到最后一个小于目标值的数
    public static void main(String[] args) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        int i = Integer.parseInt("10", 2);
        System.out.println(i);
        Map<String,String> map = new TreeMap<>();



        //int[] arr = {1, 3, 5, 7};
        //int target = 4;
        //int l = 0, r = arr.length - 1;
        //while (l < r) {
        //    int m = l + r + 1>> 1;
        //    if (arr[m] <= target) {
        //        l = m ;
        //    } else {
        //        r = m - 1;
        //    }
        //}
        //System.out.println(l);
    }
}
