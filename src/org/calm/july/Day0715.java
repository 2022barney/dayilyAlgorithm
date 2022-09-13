package org.calm.july;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: nolai
 * @date: 2022/7/15
 * @version: v1.0
 * ---------------------------
 */
public class Day0715 {

    public static void main(String[] args) {
        List<int[]>[] arr = new ArrayList[10];
        List<int[]> inters = arr[1];
    }
}

class Solution {
    public Node4 intersect(Node4 quadTree1, Node4 quadTree2) {
        int[] arr = new int[10];
        int[] ints = Arrays.copyOf(arr, arr.length);
        return null;
    }
}


// Definition for a QuadTree Node4.
class Node4 {
    public boolean val;
    public boolean isLeaf;
    public Node4 topLeft;
    public Node4 topRight;
    public Node4 bottomLeft;
    public Node4 bottomRight;

    public Node4() {}

    public Node4(boolean _val,boolean _isLeaf,Node4 _topLeft,Node4 _topRight,Node4 _bottomLeft,Node4 _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

