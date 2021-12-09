package top.lconcise.practice.leetcode;

/**
 * 19. 删除链表倒数第
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

        listNode.forEach(listNode);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

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


class ListNode {
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

    public void forEach(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
