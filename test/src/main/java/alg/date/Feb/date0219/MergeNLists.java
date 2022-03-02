package alg.date.Feb.date0219;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class MergeNLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode res = new ListNode(-1);
        ListNode head = res;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode temp = priorityQueue.poll();
            res.next = temp;
            if (temp.next != null) {
                priorityQueue.offer(temp.next);
            }
            res = res.next;
        }
        return head;
    }
}
