package ds.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
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