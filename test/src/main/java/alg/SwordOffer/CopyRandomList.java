package alg.SwordOffer;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *
 * 示例 1：
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            Node next = temp.next;
            temp.next = copyNode;
            copyNode.next = next;
            temp = next;
        }

        Node sec = head;
        while (sec != null) {
            if (sec.random != null) {
                sec.next.random = sec.random.next;
            }
            sec = sec.next.next;
        }

        Node newHead = head.next;

        Node pre = head;
        Node cur = head.next;
        while (cur.next != null) {
            cur.next = cur.next.next;
            pre.next = pre.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        return newHead;

    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}