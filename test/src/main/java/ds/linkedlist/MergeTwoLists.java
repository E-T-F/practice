package ds.linkedlist;

/**
 * @Auther: etf
 * @Date: 2021-01-15 00:05
 * @Description:
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;
//
//        while (l1 != null) {
//            curr.next = l1;
//            l1 = l1.next;
//            curr = curr.next;
//        }
//
//
//        while (l2 != null) {
//            curr.next = l2;
//            l2 = l2.next;
//            curr = curr.next;
//        }
        return res.next;
    }
}
