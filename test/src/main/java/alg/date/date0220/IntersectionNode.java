package alg.date.date0220;

/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tempA = headA, tempB = headB;
        while (tempA != tempB) {
            if (tempA == null) {
                tempA = headB;
            } else {
                tempA = tempA.next;
            }

            if (tempB == null) {
                tempB = headA;
            } else {
                tempB = tempB.next;
            }
        }
        return tempA;
    }
}
