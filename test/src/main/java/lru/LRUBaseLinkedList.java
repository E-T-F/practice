package lru;

import java.util.Scanner;

/**
 * @Auther: etf
 * @Date: 2021-01-27 22:38
 * @Description:
 */
public class LRUBaseLinkedList<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;


    public LRUBaseLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
        this.headNode = new SNode<>();
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.headNode = new SNode<>();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }


    public void add(T data) {

        SNode preNode = findPreNode(data);

        //如果链表存在，则删除该结点，插入到头结点
        if (preNode != null) {
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    /**
     * 获取查找到元素的前一个结点
     *
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        SNode<T> node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void deleteElemOptim(SNode<T> preNode) {
        SNode<T> temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        length--;
    }

    private void deleteElemAtEnd() {
        SNode<T> temp = headNode;

        if (temp == null || temp.getNext() == null) {
            return;
        }

        //链表倒数第二个节点
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(null);
        length--;
    }

    /**
     * 链表头插入节点
     * @param data
     */
    private void insertElemAtBegin(T data) {
        SNode<T> next = headNode.getNext();
        headNode.setNext(new SNode<>(data, next));
        length++;
    }


}


class SNode<T> {

    private T element;

    private SNode<T> next;


    public SNode() {
        this.next = null;
    }

    public SNode(T element) {
        this.element = element;
    }

    public SNode(T element, SNode<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SNode<T> getNext() {
        return next;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }
}
