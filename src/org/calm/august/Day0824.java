package org.calm.august;

import java.util.Arrays;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/8/24
 * @version: v1.0
 * ---------------------------
 */
public class Day0824 {
    public static void main(String[] args) {
        Node node = new Node();
        int[] weights = new int[10];
        int sum = Arrays.stream(weights).sum();
    }
}

class Node {
    public Integer in;


    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        this.in = in;
    }
}
