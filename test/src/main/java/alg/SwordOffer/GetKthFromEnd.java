package alg.SwordOffer;

import java.util.LinkedList;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class GetKthFromEnd {


    /**
     * 双指针，快指针先走 k 步
     * 然后两个指针同时前进，直到快指针为 null，慢指针的位置就是所求节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        return pre;
    }




    /**
     * 使用栈全部压进去，再弹出 k 个
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode temp = head;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int i = 1;
        while (i <= k) {
            ListNode res = stack.pop();
            if (i == k) {
                return res;
            }
            i++;
        }
        return null;
    }


}
