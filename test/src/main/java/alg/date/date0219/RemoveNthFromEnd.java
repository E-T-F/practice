package alg.date.date0219;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode node = findNthFromEnd(temp, n + 1);

        if (node != null && node.next != null) {
            node.next = node.next.next;
        }

        return temp.next;
    }

    private ListNode findNthFromEnd(ListNode head, int k) {


        ListNode slow = head, fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
