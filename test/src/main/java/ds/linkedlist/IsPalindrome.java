package ds.linkedlist;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 *
 * @Auther: etf
 * @Date: 2021-01-19 22:57
 * @Description:
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node2 = new ListNode(0);
        node.next = node2;

        System.out.println(new IsPalindrome().isPalindrome(node));

    }

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }
        ListNode middle = getMiddleNode(head);

        ListNode secondHead = reverseList(middle.next);

        ListNode startTemp = head;


        ListNode secondTemp = secondHead;
        while (secondTemp != null) {
            if (secondTemp.val != startTemp.val) {
                return false;
            }
            secondTemp = secondTemp.next;
            startTemp = startTemp.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode newHead = head;

        while (newHead != null) {
            ListNode curr = newHead.next;
            newHead.next = temp;
            temp = newHead;
            newHead = curr;
        }
        return temp;
    }

    private ListNode getMiddleNode(ListNode head) {

        ListNode quick = head;
        ListNode slow = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
}
