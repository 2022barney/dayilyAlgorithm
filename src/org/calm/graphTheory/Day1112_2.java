package org.calm.graphTheory;
/**
 * ------------------------
 * 365.medium
 * ------------------------
 * @author liyang
 * @date 2022/11/12
 * @version 1.0
 * ------------------------
 */
public class Day1112_2 {


    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == targetCapacity || jug2Capacity == targetCapacity || (jug1Capacity + jug2Capacity) == targetCapacity) {
            return true;
        }
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


}
