package org.calm.October;
/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/10/19
 * @version 1.0
 * ------------------------
 */
public class Day1019 {

    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnts = new int[2];
        for (int stu : students) cnts[stu]++;
        for (int i = 0; i < students.length; i++) {
            if (--cnts[sandwiches[i]] == -1) return students.length - i;
        }
        return 0;
    }
}
