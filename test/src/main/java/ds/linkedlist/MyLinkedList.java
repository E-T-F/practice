package ds.linkedlist;

/**
 * https://leetcode-cn.com/problems/design-linked-list/
 *
 * @Auther: etf
 * @Date: 2021-01-12 23:34
 * @Description:
 */


class MyNode2 {
    int val;
    MyNode2 next;

    MyNode2(int val, MyNode2 next) {
        this.val = val;
        this.next = next;
    }
}

public class MyLinkedList {


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtHead(10);
        linkedList.addAtTail(2);
        linkedList.printAll();
        linkedList.deleteAtIndex(0);
        linkedList.printAll();

    }

    MyNode2 head = null;
    int size = 0;


    public void printAll() {
        MyNode2 temp = head;

        while (temp != null) {
            System.out.println(temp.val + " ");
            temp = temp.next;
        }
    }


    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        MyNode2 temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        size++;
        head = new MyNode2(val, head);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyNode2 node = new MyNode2(val, null);
        size++;
        if (head == null) {
            head = node;
        } else {
            MyNode2 temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node
     * will be appended to the end of linked list. If index is greater than
     * the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            return;
        }

        if (index == 0) {
            this.addAtHead(val);
            return;
        }

        MyNode2 pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }

        size++;
        pre.next = new MyNode2(val, pre.next);
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        size--;
        if (index == 0) {
            head = head.next;
            return;
        }

        MyNode2 pre = head;

        for (int i = 0; i < index - 1; i++) {
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