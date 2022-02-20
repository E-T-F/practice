package alg.date.date0219;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 */
public class DeleteNode {


    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.val != val) {
            fast = fast.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow.next = slow.next.next;
        }
        return head;
    }


    /**
     * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
     *
     * 题目数据保证需要删除的节点 不是末尾节点 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
    }
}
