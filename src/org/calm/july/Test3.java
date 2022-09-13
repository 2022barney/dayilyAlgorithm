package org.calm.july;

import java.util.*;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/13
 * @version: v1.0
 * ---------------------------
 */
public class Test3 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.size();
        String.valueOf(1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        HashMap<Object, Object> map = new HashMap<>();
        map.get(0);
        List<Integer> list = new ArrayList<Integer>();
        Collections.sort(list, (a, b) -> a -b);
        list.set(3, 10);
        System.out.println(list.size());
    }
}
