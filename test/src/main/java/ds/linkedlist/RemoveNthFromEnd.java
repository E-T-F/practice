package ds.linkedlist;

import java.util.LinkedList;

public class RemoveNthFromEnd {

    /**
     * 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/linked-list/jf1cc/
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode quick = head;
        ListNode slow = temp;
        for (int i = 0; i < n; i++) {
            if (quick == null) {
                return null;
            }
            quick = quick.next;
        }
        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        LinkedList<ListNode> linkedList = new LinkedList<>();
        ListNode copy = new ListNode(0);
        copy.next = head;
        ListNode temp = copy;
        while (temp != null) {
            linkedList.push(temp);
            temp = temp.next;
        }
        for (int i = 0; i < n; i++) {
            linkedList.pop();
        }
        ListNode pre = linkedList.peek();
        pre.next = pre.next.next;
        return copy.next;
    }
}
