package top.lconcise.practice.leetcode;

import java.util.Deque;
import java.util.LinkedList;

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

        ListNode listNode = removeNthFromEnd02(head, 1);

        ListNode.forEach(listNode);
    }

    /**
     * 方法一：计算链表长度
     * <p>
     * 1. 获取链表长度
     * 2. 遍历链表，找到节点length-n. 该节点 current.next = current.next.next
     * <p>
     * 时间复杂度：O(L),其中L为链表长度
     * 空间复杂度：O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd01(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode current = pre;

        int length = getListNodeLength(head);

        int subLength = length - n;

        while (subLength != 0) {
            current = current.next;
            --subLength;
        }

        current.next = current.next.next;

        return pre.next;
    }

    public static int getListNodeLength(ListNode head) {
        int length = 0;

        while (head != null) {
            ++length;
            head = head.next;
        }

        return length;
    }

    /**
     * 方法二：栈
     * 先入栈，再出栈
     * <p>
     * 时间复杂度：O(L)，L链表的长度
     * 空间复杂度：O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd02(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode current = pre;
        Deque<ListNode> stack = new LinkedList<>();

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        while (n != 0) {
            stack.pop();
            --n;
        }
        stack.peek().next = stack.peek().next.next;
        return pre.next;
    }

    /**
     * 方法三：双指针.
     *
     * 时间复杂度：O(L),其中L是链表的长度
     * 空间复杂度：O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd03(ListNode head, int n) {

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


