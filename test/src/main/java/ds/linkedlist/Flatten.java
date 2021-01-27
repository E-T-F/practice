package ds.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 扁平化多级双向链表
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/linked-list/fw8v5/
 *
 * @Auther: etf
 * @Date: 2021-01-23 09:07
 * @Description:
 */
public class Flatten {


    public static void main(String[] args) {
        ChildNode node1 = new ChildNode(1);
        ChildNode node2 = new ChildNode(3);
        ChildNode node3 = new ChildNode(4);
        ChildNode node4 = new ChildNode(7);
        ChildNode node5 = new ChildNode(8);
        ChildNode node6 = new ChildNode(9);
        ChildNode node7 = new ChildNode(10);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node2.child = node4;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        node5.child = node7;
        ChildNode head = new Flatten().flatten(node1);
        System.out.println(head);


        System.out.println(node1);

    }

    public ChildNode flatten(ChildNode head) {
        if (head == null) {
            return head;
        }

        ChildNode tempHead = new ChildNode(0);

        ChildNode prev = tempHead;
        Deque<ChildNode> stack = new ArrayDeque<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            ChildNode curr = stack.pop();
            curr.prev = prev;
            prev.next = curr;
            if (curr.next != null) {
                stack.push(curr.next);
            }

            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            prev = curr;
        }
        tempHead.next.prev = null;
        return tempHead.next;
    }

    public ChildNode flatten2(ChildNode head) {
        ChildNode temp = head;
        LinkedList<ChildNode> lastLevel = new LinkedList<>();
        while (temp != null) {
            if (temp.child != null) {
                if (temp.next != null) {
                    lastLevel.push(temp.next);
                }
                ChildNode child = temp.child;
                temp.next = child;
                temp.child = null;
                child.prev = temp;
            }
            if (temp.next == null && lastLevel.peek() != null) {
                ChildNode next = lastLevel.pop();
                temp.next = next;
                next.prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }


    public ChildNode flattenWithRecursion(ChildNode head) {
        if (head == null) {
            return null;
        }
        ChildNode tempHead = new ChildNode(0);
        flattenDfs(tempHead, head);

        return tempHead.next;
    }

    /**
     * 返回tail结点
     *
     * @param prev
     * @param curr
     * @return
     */
    private ChildNode flattenDfs(ChildNode prev, ChildNode curr) {
        if (curr == null) {
            return prev;
        }
        prev.next = curr;
        curr.prev = prev;

        ChildNode temp = curr.next;

        ChildNode tail = flattenDfs(curr, curr.child);

        curr.child = null;

        return flattenDfs(tail, temp);

    }
}


class ChildNode {
    public int val;
    public ChildNode prev;
    public ChildNode next;
    public ChildNode child;

    public ChildNode(int val) {
        this.val = val;
    }
}