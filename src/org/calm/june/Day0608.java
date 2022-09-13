package org.calm.june;


import java.util.Arrays;
import java.util.Date;

public class Day0608 {
    /**
     * [[1,1],[2,2],[3,3]]
     * [[0,0],[1,0],[2,2]]
     * @param points
     * @return
     */
    public static void main(String[] args) {
        //boolean boomerang = isBoomerang(new int[][]{{0, 0}, {1, 0}, {2, 2}});
        //System.out.println(boomerang);
        Date date = new Date();
        System.out.println(date);
    }

    public static boolean isBoomerang(int[][] points) {
        int length = points.length;
        if (length != 3) return false;
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int aX = points[1][0];
        int aY = points[1][1];
        double l1 = getLen(aX, aY, points[0][0], points[0][1]);
        double l2 = getLen(aX, aY, points[2][0], points[2][1]);
        double l3 = getLen(points[2][0], points[2][1], points[0][0], points[0][1]);
        System.out.println("l1"+ l1);
        System.out.println("l2"+ l2);
        System.out.println("l3"+ l3);
        System.out.println(l1 + l2 + "l1 + l2");
        return  l1 + l2 != l3;
    }

    static double getLen(int x1,int y1,int x2, int y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }
    static int gcd(int a, int b) {
        return 0;
    }

}
