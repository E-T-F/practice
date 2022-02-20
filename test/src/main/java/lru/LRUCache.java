package lru;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 */
public class LRUCache {


    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(3);
        lruCache.put("key1", 6);
        lruCache.put("key2", 2);
        lruCache.put("key3", 8);
        lruCache.printAll();
        lruCache.put("key4", 0);
        lruCache.printAll();
        lruCache.get("key2");
        lruCache.printAll();
    }

    private ConcurrentHashMap<String, Node> cache = new ConcurrentHashMap<>();
    private int count;
    private int capacity;
    private Node head, tail;


    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new Node();
        head.pre = null;

        tail = new Node();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(String key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }


    public void put(String key, int value) {
        Node node = cache.get(key);
        //存在则更新
        if (node != null) {
            moveToHead(node);
            return;
        }

        //新增
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;

        cache.put(key, newNode);
        addNode(newNode);
        count++;

        if (count > capacity) {
            Node tail = popTail();
            cache.remove(tail.key);
            count--;
        }

    }

    private Node popTail() {
        Node temp = tail.pre;
        removeNode(temp);
        return temp;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(Node node) {
        Node pre = node.pre;
        Node post = node.post;

        pre.post = post;
        post.pre = pre;
    }


    public void printAll() {
        Node node = head.post;
        while (node != null && node.key != null) {
            System.out.print(node.key + ":" + node.value + ",");
            node = node.post;
        }
        System.out.println();
    }

    class Node {
        String key;
        int value;
        Node pre;
        Node post;
    }


}
