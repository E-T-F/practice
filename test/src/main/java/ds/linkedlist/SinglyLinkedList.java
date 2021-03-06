package ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: etf
 * @Date: 2020-10-31 14:54
 * @Description:
 */
public class SinglyLinkedList<T> {

    private Node<T> head = null;

    public Node<T> findByValue(T value) {
        Node<T> temp = head;
        while (temp != null && !temp.getData().equals(value)) {
            temp = temp.getNext();
        }
        return temp;
    }

    public Node<T> findByIndex(int index) {
        Node<T> temp = head;
        int pos = 0;
        while (temp != null && pos != index) {
            temp = temp.getNext();
            pos++;
        }
        return temp;
    }


    public void insertToHead(T data) {
        Node<T> newNode = new Node<>(data, null);
        insertToHead(newNode);
    }

    private void insertToHead(Node<T> newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }


    public void insertToTail(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);

        }
    }

    public void insertAfter(Node<T> node, T value) {
        Node<T> newNode = new Node<>(value, null);
        insertAfter(node, newNode);
    }

    public void insertAfter(Node<T> node, Node<T> newNode) {
        if (node == null) {
            return;
        }
        newNode.setNext(node.getNext());
        node.setNext(newNode);
    }


    public void insertBefore(Node<T> node, T value) {
        Node<T> newNode = new Node<>(value, null);
        insertBefore(node, newNode);
    }

    public void insertBefore(Node<T> node, Node<T> newNode) {

        if (node == head) {
            insertToHead(newNode);
            return;
        }

        Node<T> temp = head;
        while (temp != null && temp.getNext() != node) {
            temp = temp.getNext();
        }

        if (temp == null) {
            return;
        }

        newNode.setNext(node);
        temp.setNext(newNode);

    }

    public void deleteByNode(Node<T> node) {
        if (node == null || head == null) {
            return;
        }
        if (node == head) {
            head = head.getNext();
            return;
        }

        Node<T> temp = head;

        while (temp != null && !temp.getNext().equals(node)) {
            temp = temp.getNext();
        }

        if (temp == null) {
            return;
        }

        temp.setNext(temp.getNext().getNext());
    }

    public void deleteByValue(T value) {

        if (head == null) {
            return;
        }

        Node<T> temp = head;
        Node<T> before = null;
        while (temp != null && temp.getData() != value) {
            before = temp;
            temp = temp.getNext();
        }

        if (temp == null) {
            return;
        }

        if (before == null) {
            head = head.getNext();
        } else {
            before.setNext(temp.getNext());
        }
    }


    public void printAll() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.println(temp.getData() + " ");
            temp = temp.getNext();
        }
    }


    /**
     * 相关算法
     */


    // 1. 求链表的中间结点
    public Node<T> getMiddleNode() {
        Node<T> slow = head;
        Node<T> quick = head;
        if (slow == null || slow.getNext() == null) {
            return slow;
        }
        while (quick.getNext() != null && quick.getNext().getNext() != null) {
            slow = slow.getNext();
            quick = quick.getNext().getNext();
        }
        return slow;
    }

    // 2. 链表反转
    public Node<T> inverseLinkList(Node<T> head) {

        Node<T> pre = null;
        Node<T> current = head;

        while (current != null) {
            Node<T> temp = current.getNext();
            current.setNext(pre);
            pre = current;
            current = temp;
        }
        return pre;
    }

    public Node<T> inverseLinkListWithRecursion(Node<T> head) {

        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<T> newHead = inverseLinkListWithRecursion(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;

    }


    // 3. 链表中环的检测
    public boolean hasCycle(Node<T> head) {
        Node<T> quick = head;
        Node<T> slow = head;

        if (head == null || head.getNext() == null) {
            return false;
        }

        while (slow.getNext() != null && quick.getNext().getNext() != null) {
            slow = slow.getNext();
            quick = quick.getNext().getNext();

            if (quick == null || quick.getNext() == null) {
                return false;
            }
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }


    public boolean hasCycle2(Node<T> head) {
        Node<T> quick = head;
        Node<T> slow = head;

        if (head == null || head.getNext() == null) {
            return false;
        }
        quick = quick.getNext().getNext();
        slow = slow.getNext();

        while (quick != slow) {
            if (quick == null || quick.getNext() == null) {
                return false;
            }
            quick = quick.getNext().getNext();
            slow = slow.getNext();
        }
        return true;
    }

    public boolean hasCycle3(Node<T> head) {
        Set<Node<T>> set = new HashSet<>();
        Node<T> node = head;
        while (node != null) {
            if (!set.add(node)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    // 4. 两个有序的链表合并
    // 5. 删除链表倒数第 n 个结点
    // 6. 判断回文

    public static void main(String[] args) {

        SinglyLinkedList<Integer> link = new SinglyLinkedList<Integer>();
        int data[] = {1, 2, 3, 4};
        // int data[] = {1,2,5,2,1};
//        int data[] = {1, 2, 5, 3, 1};

        for (int i = 0; i < data.length; i++) {
            //link.insertToHead(data[i]);
            link.insertToTail(data[i]);
        }


        Node<Integer> node = new Node<>(5, link.findByIndex(2));
        link.insertAfter(link.findByIndex(3), node);

        link.printAll();

        System.out.println(link.hasCycle(link.head));
    }
}
