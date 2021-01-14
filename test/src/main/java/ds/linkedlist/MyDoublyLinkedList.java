package ds.linkedlist;

/**
 * @Auther: etf
 * @Date: 2021-01-13 23:43
 * @Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int x) { val = x; }
}


public class MyDoublyLinkedList {

    public static void main(String[] args) {
        MyDoublyLinkedList linkedList = new MyDoublyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.printAll();

        linkedList.addAtIndex(1, 2);
        linkedList.printAll();
        linkedList.deleteAtIndex(1);
        linkedList.printAll();

    }
    ListNode head, tail;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyDoublyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;

    }

    public void printAll() {
        ListNode temp = head;

        while (temp != null) {
            System.out.println(temp.val + " ");
            temp = temp.next;
        }
    }




    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode curr = head;

        //choose the fastest way
        if (index + 1 < size - index) {
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = 0; i < size - index; i++) {
                curr = curr.prev;
            }
        }
        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        size++;
        ListNode prev = head;
        ListNode curr = head.next;
        node.next = curr;
        node.prev = prev;
        curr.prev = node;
        prev.next = node;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        size++;
        ListNode node = new ListNode(val);
        ListNode prev = tail.prev;
        ListNode curr = tail;
        node.next = curr;
        node.prev = prev;
        curr.prev = node;
        prev.next = node;
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

//        if (index == 0) {
//            this.addAtHead(val);
//            return;
//        }

        ListNode pre = head;
        ListNode curr;
        //choose the fastest way
        if (index + 1 < size - index) {
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            curr = pre.next;
        } else {
            curr = tail;
            for (int i = 0; i < size - index; i++) {
                curr = curr.prev;
            }
            pre = curr.prev;

        }
        size++;
        ListNode node = new ListNode(val);
        node.next = curr;
        node.prev = pre;
        curr.prev = node;
        pre.next = node;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

//        if (index == 0) {
//            head = head.next;
//            return;
//        }

        ListNode pre = head;
        ListNode curr;
        //choose the fastest way
        if (index < size - index) {
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            curr = pre.next.next;
        } else {
            curr = tail;
            for (int i = 0; i < size - index - 1; i++) {
                curr = curr.prev;
            }
            pre = curr.prev.prev;

        }

        size--;

        pre.next = curr;
        curr.prev = pre;

    }
}




