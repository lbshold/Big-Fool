package top.lconcise.practice.demo;

/**
 * @author liusj
 * @date 2021/8/4
 */
public class ListNode {

    public int data;

    public ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public void addTail(ListNode head, int data) {
        if (head == null) {
            return;
        }

        ListNode next = new ListNode(data);
        while (head.next != null) {
            head = head.next;
        }

        head.next = next;
    }

    public void foreach(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode reverse01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverse01(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverse02(ListNode head) {
        ListNode pre = null;
        ListNode current = head;

        while (current != null) {
            ListNode newHead = current.next;
            current.next = pre;
            pre = current;
            current = newHead;
        }

        return pre;
    }
}
