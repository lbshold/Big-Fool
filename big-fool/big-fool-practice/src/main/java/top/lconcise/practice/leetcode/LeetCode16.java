package top.lconcise.practice.leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和.
 *
 * @author: liusj
 * @date: 2021/11/5
 */
public class LeetCode16 {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     * 示例：
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     */

    public static void main(String[] args) {
        // 排序 双指针
        int[] arrays = {-1, 2, 1, -4};
        System.out.println(lastNear(arrays, 1));
    }

    public static int lastNear(int[] nums, int target) {
        // 1. 排序
        Arrays.sort(nums);
        // 2. 双指针
        int ans = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum < target) {
                    i++;
                } else if (sum > target) {
                    i--;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
