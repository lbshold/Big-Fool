package top.lconcise.practice.leetcode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author: liusj
 * @date: 2021/12/13
 */
public class LeetCode206 {

    /**
     * 递归.
     * <p>
     * 1. 结束条件 head.next == null;
     * 2. 递推公式 head.next.next = head; head.next = null;
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n), 其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 迭代.
     * <p>
     * 时间复杂度：0(n),其中 n 是链表的长度。需要遍历链表一次。
     * 空间复杂度：O(1)。
     *
     * @param head
     * @return
     */
    public ListNode reverse02(ListNode head) {
        ListNode pre = null;
        ListNode current = head;

        while (current != null) {
            ListNode newNode = current.next;
            current.next = pre;
            pre = current;
            current = newNode;
        }

        return pre;
    }

}
