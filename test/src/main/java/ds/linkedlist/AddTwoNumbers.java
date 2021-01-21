package ds.linkedlist;

/**
 * @Auther: etf
 * @Date: 2021-01-21 23:07
 * @Description:
 */
public class AddTwoNumbers {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);
        ListNode l25 = new ListNode(8);
        ListNode l26 = new ListNode(9);
        ListNode l27 = new ListNode(9);
        l2.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;
        l25.next = l26;
        l26.next = l27;

        new AddTwoNumbers().addTwoNumbers(l1, l2);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up = 0;
        int remainder = 0;
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + up;
            up = val / 10;
            remainder = val % 10;
            curr.next = new ListNode(remainder);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            addNumber(l2, curr, up);
        } else {
            addNumber(l1, curr, up);
        }
        return newHead.next;
    }

    public void addNumber(ListNode node, ListNode curr, int up) {
        int upp = up;
        while (node != null) {
            int val = node.val + upp;
            upp = val / 10;
            int remainder = val % 10;
            curr.next = new ListNode(remainder);
            curr = curr.next;
            node = node.next;
        }
        if (upp > 0) {
            curr.next = new ListNode(upp);
        }
    }
}
