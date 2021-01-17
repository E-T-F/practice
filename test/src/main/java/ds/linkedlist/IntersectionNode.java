package ds.linkedlist;

public class IntersectionNode {

    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        if (headA == null || headB == null) {
            return null;
        }
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null && tempB != null) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        int diff = 0;
        boolean larA = false;
        boolean larB = false;

        while (tempA != null) {
            larA = true;
            diff++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            larB = true;
            diff++;
            tempB = tempB.next;
        }
        if (larA) {
            ListNode temp = headA;
            for (int i = 1; i <= diff; i++) {
                temp = temp.next;
            }
            return getIntersectionNodeWithEqlen(temp, headB);
        } else if (larB) {

            ListNode temp = headB;
            for (int i = 1; i <= diff; i++) {
                temp = temp.next;
            }
            return getIntersectionNodeWithEqlen(headA, temp);
        } else {
            return getIntersectionNodeWithEqlen(headA, headB);
        }
    }

    private ListNode getIntersectionNodeWithEqlen(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA == null || nodeB == null) {
                return null;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return nodeA;
    }
}
