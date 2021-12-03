package top.lconcise.practice.leetcode;

import top.lconcise.practice.demo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表环路检测.
 *
 * @author: liusj
 * @date: 2021/11/25
 */
public class LeetCode0208 {


    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;

        Set<ListNode> set = new HashSet<>();
        while (pos != null) {
            if (set.contains(pos)) {
                return pos;
            }
            set.add(pos);
            pos = pos.next;
        }
        return null;
    }
}
