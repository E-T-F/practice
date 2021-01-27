package ds.array.basic.index;

/**
 * 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/linked-list/f00a2/
 *
 * @Auther: etf
 * @Date: 2021-01-26 22:15
 * @Description:
 */
public class RotateRight {


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }
        //turn to ring
        tail.next = head;

        ListNode newTail = head;
        for (int i = 0; i < size - k % size - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;

    }

    public ListNode rotateRight2(ListNode head, int k) {

        if (head == null) {
            return head;
        }
        int size = 0;
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }


        k = k % size;

        if (size <= 1 || k == 0) {
            return head;
        }
        cur = head;
        int move = 0;
        while (move < k) {
            cur = cur.next;
            move++;
        }

        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        ListNode res = pre.next;
        pre.next = null;
        cur.next = head;
        return res;

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
