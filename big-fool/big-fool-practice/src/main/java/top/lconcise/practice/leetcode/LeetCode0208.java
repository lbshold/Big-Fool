package top.lconcise.practice.leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 * 面试题02.08 链表环路检测.
 *
 * @author: liusj
 * @date: 2021/11/25
 */
public class LeetCode0208 {

    /**
     * 方法一；哈希表
     * 思路与算法：一个非常直观的思路是：我们遍历链表中的每个节点，并将它记录下来；一旦遇到了此前遍历过的节点，
     * 就可以判定链表中存在环。借助哈希表可以很方便地实现。
     * <p>
     * 时间复杂度：O(N),其中 N 为链表中节点的数目。我们恰好需要访问链表中的每一个节点。
     * 空间复杂度：O(N),其中 N 为链表中节点的数目。我们需要将链表中的每个节点都保存在哈希表当中。
     *
     * @param head
     * @return
     */
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
