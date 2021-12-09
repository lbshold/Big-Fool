package top.lconcise.practice.leetcode;

import java.util.Arrays;

/**
 * 冒泡排序、选择排序、插入排序。
 *
 * @author: liusj
 * @date: 2021/12/9
 */
public class Sorts {

    /**
     * 冒泡排序.
     * <p>
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     *
     * @param a 数组
     * @param n 数组长度
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            // 这里注意n-1,边界问题：数组溢出越界
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    // 此次有数据交换
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }

    /**
     * 冒泡排序改进.在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     *
     * @param a
     * @param n
     */
    public static void bubbleSort2(int[] a, int n) {
        if (n <= 1) return;

        int tmpBorder = 0;
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            boolean flag = false;

            for (int j = 0; j < sortBorder; j++) {
                if (a[j + 1] < a[j]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    flag = true;
                    tmpBorder = j;
                }
            }
            sortBorder = tmpBorder;
            // 没有数据交换，提前退出
            if (!flag) return;
        }
    }

    /**
     * 插入排序.
     * <p>
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     *
     * @param a 数组
     * @param n 数组长度.
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; i++) {
            int val = a[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; j--) {
                if (a[j] > val) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = val;
        }
    }

    /**
     * 选择排序.
     * <p>
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     *
     * @param a
     * @param n
     */
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            int j = i + 1;
            // 查找最小值
            for (; j < n; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 5, 6, 7, 8};
//        bubbleSort(array, array.length);
        bubbleSort2(array, array.length);
//        insertionSort(array, array.length);
//        selectionSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
