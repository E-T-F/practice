package alg.date.Feb.date0219;

public class MergeKLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(3);

        ListNode node3 = new ListNode(1);
        node3.next = new ListNode(4);
        node3.next.next = new ListNode(6);

        ListNode[] lists = new ListNode[] {node1, node2, node3};
        ListNode head = new MergeKLists().mergeKLists(lists);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length);
        for (ListNode node : lists) {
            if (node != null) {
                pq.enQueue(node);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.deQueue();
            cur.next = node;
            if (node.next != null) {
                pq.enQueue(node.next);
            }
            cur = cur.next;
        }
        return head.next;
    }

}


class ListNode implements Comparable<ListNode>{
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int x) { val = x; }


    @Override
    public int compareTo(ListNode o) {
        ListNode node = (ListNode) o;
        return node.val - this.val;
    }
}
