package top.lconcise.practice.leetcode;

import top.lconcise.practice.demo.ListNode;

/**
 * 21.合并两个有序列表.
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
     * 时间复杂度：O(n+m),其中 n 和 m 分别为两个链表的长度。因为每次调用递归都会去掉l1或者l2的头结点(直到至少有一个链表为空)，
     * 函数(mergeTwoList)至多只会递归调用每个节点一次。因此时间复杂度取决于合并后的链表长度，即O(n+m)
     * 空间复杂度：O(n+m),其中 n 和 m 分别为两个链表的长度。递归调用 mergeTwoLists 函数时需要消耗栈空间，栈空间的大小取决于
     * 递归调用的深度。结束递归调用时 mergeTwoLists 函数最多调用 n+m 次，因此空间复杂度为O(n+m)
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
