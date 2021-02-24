package alg.SwordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * @Auther: etf
 * @Date: 2021-02-22 21:39
 * @Description:
 */
public class ReversePrint {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(Arrays.toString(new ReversePrint().reversePrint(head)));
    }

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int len = 0;
        while (head != null) {
            linkedList.push(head.val);
            head = head.next;
            len++;
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = linkedList.pop();
        }
        return res;
    }

    public int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        ArrayList<Integer> list = new ArrayList<>();
        ListNode newHead = reverseList(head);
        while (newHead != null) {
            list.add(newHead.val);
            newHead = newHead.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}