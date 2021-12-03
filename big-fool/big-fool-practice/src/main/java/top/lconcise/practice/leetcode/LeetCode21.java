package top.lconcise.practice.leetcode;

import top.lconcise.practice.demo.ListNode;

/**
 * 合并两个有序列表.
 *
 * @author: liusj
 * @date: 2021/12/3
 */
public class LeetCode21 {

    public static void main(String[] args) {

    }

    /**
     * 递归.
     * 1. 终止条件 l1 == null || l2 == null
     * 2. l1.next = mergeTwoLists
     * <p>
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.data <= l2.data) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
