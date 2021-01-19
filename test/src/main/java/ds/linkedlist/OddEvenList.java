package ds.linkedlist;

/**
 *
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/linked-list/fe0kj/
 *
 * @Auther: etf
 * @Date: 2021-01-19 22:19
 * @Description:
 */
public class OddEvenList {


    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode even = head;
        ListNode odd = head.next;
        ListNode oddTemp = head.next;

        while (even.next != null && even.next.next != null) {
            even.next = even.next.next;
            oddTemp.next = oddTemp.next.next;
            even = even.next;
            oddTemp = oddTemp.next;
        }
        even.next = odd;
        return head;
    }
}
