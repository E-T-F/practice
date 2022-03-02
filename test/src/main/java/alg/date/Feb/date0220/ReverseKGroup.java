package alg.date.Feb.date0220;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode left = head, right = head;
        for (int i = 0; i < k; i++) {
            if (right == null) {
                // 不足 k 个，不需要反转，base case
                return head;
            }
            right = right.next;
        }
        //反转前N个节点
        ListNode last = reverse(left, right);
        //递归反转子问题
        left.next = reverseKGroup(right, k);
        return last;

    }

    /**
     * 左闭右开
     * @param left
     * @param right
     * @return
     */
    private ListNode reverse(ListNode left, ListNode right) {
        if (left == null) {
            return null;
        }
        ListNode pre = null, cur = left;
        while (cur != right) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
