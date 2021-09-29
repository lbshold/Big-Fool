package top.lconcise.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liusj
 * @date 2021/9/26
 */
public class LeetCode349 {

    public static void main(String[] args) {
        int[] array01 = {1, 2, 2, 1};
        int[] array02 = {2, 2};
        intersection(array01, array02);
        intersection02(array01, array02);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        // 遍历获取交集，Set集合去重
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                }
            }
        }

        // Set集合转数组
        int[] a = new int[set.size()];
        int index = 0;
        for (int i : set) {
            a[index++] = i;
        }
        return a;
    }

    public static int[] intersection02(int[] nums1, int[] nums2) {
        // 比较数组大小
        int[] maxNum;
        int[] minNum;
        if (nums1.length > nums2.length) {
            maxNum = nums1;
            minNum = nums2;
        } else {
            maxNum = nums2;
            minNum = nums1;
        }
        // 数组大的转Set集合，Set集合去重
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < maxNum.length; i++) {
            set.add(maxNum[i]);
        }
        // 遍历小的数组，取交集
        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < minNum.length; i++) {
            if (set.contains(minNum[i])) {
                resultSet.add(minNum[i]);
            }
        }
        // Set集合转数组
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int x : resultSet) {
            result[i++] = x;
        }

        return result;
    }
}
