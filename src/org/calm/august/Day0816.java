package org.calm.august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/8/16
 * @version: v1.0
 * ---------------------------
 */
public class Day0816 {

    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        ArrayList<Integer> list2=((ArrayList<Integer>) ((ArrayList<Integer>) l1).clone());
        List<Integer> l2 = new ArrayList<>();
        Collections.copy(l2, l1);
        l1.set(0, 3);
        for (Integer o : l2) {
            System.out.println(o);
        }
    }

}
