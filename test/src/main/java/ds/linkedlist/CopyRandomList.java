package ds.linkedlist;

import java.util.HashMap;

/**
 * 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的 深拷贝。 
 * <p>
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *  
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/linked-list/fdi26/
 *
 * @Auther: etf
 * @Date: 2021-01-24 14:04
 * @Description:
 */
public class CopyRandomList {
    HashMap<RandomNode, RandomNode> existed = new HashMap<>();


    public RandomNode copyRandomList2(RandomNode head) {

        if (head == null) {
            return null;
        }
        RandomNode curr = head;
        //A->B->C to A->A`->B->B`->C->C`
        while (curr != null) {
            RandomNode node = new RandomNode(curr.val);
            node.next = curr.next;
            curr.next = node;
            curr = node.next;
        }


        curr = head;
        //random node
        while (curr != null) {
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
        }

        //split
        RandomNode oldList = head;
        RandomNode newList = head.next;
        RandomNode res = head.next;
        while (oldList != null) {
            oldList.next = oldList.next.next;
            newList.next = newList.next == null ? null : newList.next.next;
            oldList = oldList.next;
            newList = newList.next;
        }
        return res;
    }


    public RandomNode copyRandomListWithRecursion(RandomNode head) {

        if (head == null) {
            return null;
        }

        if (existed.containsKey(head)) {
            return existed.get(head);
        }
        RandomNode newHead = new RandomNode(head.val);

        existed.put(head, newHead);
        newHead.random = copyRandomListWithRecursion(head.random);
        newHead.next = copyRandomListWithRecursion(head.next);

        return newHead;

    }

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null;
        }

        RandomNode oldHead = head;
        RandomNode newHead = new RandomNode(oldHead.val);
        RandomNode temp = newHead;

        HashMap<RandomNode, RandomNode> existed = new HashMap<>();
        existed.put(oldHead, temp);
        while (oldHead != null) {
            temp.next = copyRandomNode(oldHead.next, existed);
            temp.random = copyRandomNode(oldHead.random, existed);
            oldHead = oldHead.next;
            temp = newHead.next;
        }
        return newHead;
    }

    private RandomNode copyRandomNode(RandomNode temp, HashMap<RandomNode, RandomNode> existedNodes) {
        if (temp == null) {
            return null;
        }
        if (existedNodes.containsKey(temp)) {
            return existedNodes.get(temp);
        } else {
            existedNodes.put(temp, new RandomNode(temp.val));
            return existedNodes.get(temp);
        }
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