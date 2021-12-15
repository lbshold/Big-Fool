package top.lconcise.practice.leetcode;

/**
 * @author: liusj
 * @date: 2021/12/13
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void addTail(ListNode head, int data) {
        if (head == null) {
            return;
        }
        ListNode newNode = new ListNode(data);
        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
    }

    public static void forEach(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
