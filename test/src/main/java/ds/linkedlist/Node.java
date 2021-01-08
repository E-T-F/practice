package ds.linkedlist;

/**
 * @Auther: etf
 * @Date: 2020-10-31 14:56
 * @Description:
 */
public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<T> createNode(T data) {
        return new Node<>(data, null);
    }


    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> nextNode) {
        next = nextNode;
    }

}
