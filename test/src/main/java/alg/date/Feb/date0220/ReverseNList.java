package alg.date.Feb.date0220;

public class ReverseNList {


    /**
     * 反转前 n 个节点
     * @param head
     * @param n
     * @return
     */
    ListNode successor = null;
    public ListNode reverseNList(ListNode head, int n) {
        if (n == 1) {
            //需记录第N个节点的后继节点
            successor = head.next;
            return head;
        }

        ListNode last = reverseNList(head, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
