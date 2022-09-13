package org.calm.august;
/**
 * ---------------------------
 *
 * ---------------------------
 * @author: liyang
 * @date: 2022/8/10
 * @version: v1.0
 * ---------------------------
 */
public class Day0810 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner();
        int[] arr = new int[]{3, 1, 2, 3, 5};
        quickSort(arr, 0, 4);
        for (int i = 0; i < 5; i++){
            System.out.print(arr[i]);
        }
    }

    public static void quickSort(int[] arr, int l , int r) {
        if (l >= r) {
            return;
        }
        int pivot = arr[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[i] < pivot) {
                i++;
            }
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            swap(arr, i, j);
        }

        quickSort(arr, l, j);
        quickSort(arr, j + 1, r);

    }
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
