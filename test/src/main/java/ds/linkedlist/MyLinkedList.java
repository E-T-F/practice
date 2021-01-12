package ds.linkedlist;

/**
 *
 * https://leetcode-cn.com/problems/design-linked-list/
 *
 *
 * @Auther: etf
 * @Date: 2021-01-12 23:34
 * @Description:
 */


class MyNode {
    int val;
    MyNode next;

    MyNode(int val, MyNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MyLinkedList {


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.printAll();
        linkedList.deleteAtIndex(0);
        linkedList.printAll();

    }

    MyNode head = null;

    int size;


    public void printAll() {
        MyNode temp = head;

        while (temp != null) {
            System.out.println(temp.val + " ");
            temp = temp.next;
        }
    }


    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        size = 0;
        head = new MyNode(0, null);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }
        MyNode node = head;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node
     * will be appended to the end of linked list. If index is greater than
     * the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }

        ++size;
        MyNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new MyNode(val, pre.next);
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;

        MyNode pre = head;

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */