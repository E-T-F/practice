package alg.date.Feb.date0219;


/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode res = new ListNode(-1);
        ListNode head = res, l1 = list1, l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if (l1 != null) {
            res.next = l1;
        }

        if (l2 != null) {
            res.next = l2;
        }
        return head.next;
    }
}
