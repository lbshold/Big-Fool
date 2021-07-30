package top.lconcise.practice.demo;

import java.util.HashMap;

/**
 * @author liusj
 * @date 2021/7/30
 */
public class NodeDemo {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        head.addTail(head,2);
        head.addTail(head,3);
        head.addTail(head,4);

        head.foreach(head);

        ListNode listNode = head.reverse01(head);

        head.foreach(listNode);
    }
}
