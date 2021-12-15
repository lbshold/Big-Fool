package top.lconcise.practice.leetcode;

/**
 * 19. 删除链表倒数第 N 个节点
 *
 * @author: liusj
 * @date: 2021/12/8
 */
public class LeetCode19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.addTail(head, 2);
//        head.addTail(head, 3);
//        head.addTail(head, 4);
//        head.addTail(head, 5);

        head.forEach(head);

        ListNode listNode = removeNthFromEnd(head, 1);

        ListNode.forEach(listNode);
    }

    /**
     * 双指针.
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;

        while (n != 0) {
            start = start.next;
            n--;
        }

        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;

        return pre.next;
    }

}


