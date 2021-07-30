package top.lconcise.practice.demo;

import java.util.List;

/**
 * @author liusj
 * @date 2021/7/30
 */
public class ListNode {

    public int data;

    public ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public void addTail(ListNode head, int data) {
        ListNode next = new ListNode(data);

        while (head.next != null) {
            head = head.next;
        }

        head.next = next;
    }

    public void foreach(ListNode head) {
        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public ListNode reverse01(ListNode head) {
        ListNode pre = null;
        ListNode current = head;

        while (current != null){
            ListNode newHead = current.next;
            current.next = pre;
            pre = current;
            current = newHead;
        }

        return pre;
    }

    public ListNode reverse02(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverse02(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
