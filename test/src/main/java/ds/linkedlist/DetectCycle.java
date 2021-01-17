package ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/linked-list/jjhf6/
     *
     * @param head
     * @return
     */
    public MyNode detectCycle(MyNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        MyNode slow = head;
        MyNode quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                MyNode cur = head;
                while (cur != quick) {
                    cur = cur.next;
                    quick = quick.next;
                }
                return quick;
            }
        }
        return null;

    }




    public MyNode detectCycle2(MyNode head) {
        Set<MyNode> exists = new HashSet<>();
        MyNode node = head;
        while (node != null && !exists.contains(node)) {
            exists.add(node);
            node = node.next;
        }

        if (node == null) {
            return null;
        } else {
            return node;
        }
    }
}
