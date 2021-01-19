package ds.linkedlist;

/**
 * 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/linked-list/f9izv/
 *
 * @Auther: etf
 * @Date: 2021-01-19 00:11
 * @Description:
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode temp = slow;
        ListNode quick = head;
        while (quick != null) {
            if (quick.val == val) {
                slow.next = quick.next;
            } else {
                slow = quick;
            }
            quick = quick.next;
        }
        return temp.next;
    }
}


