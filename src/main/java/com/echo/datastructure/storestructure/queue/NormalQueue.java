package com.echo.datastructure.storestructure.queue;

/**
 * 普通单向队列，左进右出
 * @author dongzhang
 * */
public class NormalQueue {

    private Node dummyHead;
    private Node dummyTail;
    private int size;

    public NormalQueue() {
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

        size = 0;
    }

    //入队
    public void enqueue(int e) {
        Node newNode = new Node(e, dummyHead, dummyHead.next);
        dummyHead.next.prev = newNode;
        dummyHead.next = newNode;
        size ++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalArgumentException("queue empty.");
        }
        Node node = dummyTail.prev;
        dummyTail.prev = node.prev;
        node.prev.next = dummyTail;

        node.prev = null;
        node.next = null;
        size --;
        return node.data;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (size > 0) {
            Node cur = dummyHead.next;
            while (cur != dummyTail) {
                stringBuilder.append(cur.data);
                if (cur.next != dummyTail) {
                    stringBuilder.append(",");
                }
                cur = cur.next;
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private static class Node {

        int data;
        Node next;
        Node prev;

        public Node() {}
        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        NormalQueue queue = new NormalQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
