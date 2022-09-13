package org.calm.july;

import java.util.ArrayList;
import java.util.List;

/**
 * ---------------------------
 * 729. medium
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/5
 * @version: v1.0
 * ---------------------------
 */
public class Day0705 {

    public static void main(String[] args) {

    }
}

class MyCalendar {

    /**
     * ["MyCalendar","book","book","book"]
     * [[],[10,20],[15,25],[20,30]]
     */
    List<int[]> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : list) {
            int s = arr[0], e = arr[1];
            if (start > e || end < s) {
                continue;
            }
            return false;
        }
        return true;
    }


}
