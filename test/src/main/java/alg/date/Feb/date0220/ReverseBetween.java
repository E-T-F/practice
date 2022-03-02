package alg.date.Feb.date0220;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class ReverseBetween {


    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == 1) {
            return reverseNList(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;

    }

    private ListNode successor = null;
    private ListNode reverseNList(ListNode head, int len) {
        if (len == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseNList(head.next, len - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }


    public ListNode reverseBetweenWithSpilt(ListNode head, int left, int right) {

        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode pre = temp;

        //left-1 node
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        //right node
        ListNode rightNode = pre;
        for (int i = 0; i <= right - left; i++) {
            rightNode = rightNode.next;
        }

        //切割出来
        ListNode afterNode = rightNode.next;
        ListNode leftNode = pre.next;
        pre.next = null;
        rightNode.next = null;

        reverseList(leftNode);
        //接回原链表
        pre.next = rightNode;
        leftNode.next = afterNode;
        return temp.next;

    }

    private void reverseList(ListNode leftNode) {
        if (leftNode == null || leftNode.next == null) {
            return;
        }

        reverseList(leftNode.next);
        leftNode.next.next = leftNode;
        leftNode.next = null;
    }


}
