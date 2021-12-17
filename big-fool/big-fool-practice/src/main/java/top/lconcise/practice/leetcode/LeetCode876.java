package top.lconcise.practice.leetcode;

/**
 * 876. 链表的中间节点。
 *
 * @author: liusj
 * @date: 2021/12/15
 */
public class LeetCode876 {

    /**
     * 1. 求数组长度
     * 2. 取值 length/2
     * <p>
     * 时间复杂度：O(L), 其中L为链表长度。
     * 空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            ++length;
            current = current.next;
        }
        current = head;
        for (int i = 0; i < length / 2; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * 快慢指针.
     * 时间复杂度：O(N)O(N)，其中 NN 是给定链表的结点数目
     * 空间复杂度：O(1)O(1)，只需要常数空间存放 slow 和 fast 两个指针
     *
     * @param head
     * @return
     */
    public ListNode middleNode02(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
