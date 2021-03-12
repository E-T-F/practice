package alg.SwordOffer;

import java.util.HashMap;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class CopyRandomList {


    public RandomNode copyRandomList(RandomNode head) {

        if (head == null) {
            return null;
        }

        // 两遍 a->b->c  =》 a->a->b->b->c->c
        RandomNode cur = head;
        while (cur != null) {

            RandomNode copy = new RandomNode(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        //random node
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //拆分两个list
        cur = head;
        RandomNode newHead = head.next;
        RandomNode temp = newHead;
        while (temp.next != null) {
            cur.next = cur.next.next;
            temp.next = temp.next.next;
            cur = cur.next;
            temp = temp.next;
        }
        //处理原链表尾节点
        cur.next = null;
        return newHead;
    }


    public RandomNode copyRandomList2(RandomNode head) {

        if (head == null) {
            return null;
        }

        HashMap<RandomNode, RandomNode> mapping = new HashMap<>();
        RandomNode cur = head;
        while (cur != null) {
            RandomNode copy = new RandomNode(cur.val);
            mapping.put(cur, copy);
            cur = cur.next;
        }


        cur = head;


        while (cur != null) {
            mapping.get(cur).next = mapping.get(cur.next);
            mapping.get(cur).random = mapping.get(cur.random);
            cur = cur.next;
        }
        return mapping.get(head);
    }

}


class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}