package com.echo.datastructure.storestructure.stack;

/**
 * 用链表实现栈.
 * @author dongzhang
 * */
public class LinkedStack {

    /**
     * 1. 初始化
     * 2. 入栈
     * 3. 出栈
     * 4. 打印
     * */

    private Node head;
    private int size;

    public LinkedStack () {
        this.size = 0;
    }

    public void push(int e) {
        if (head == null) {
            this.head = new Node(e, null);
        } else {
            Node newNode = new Node(e, head);
            head = newNode;
        }
        size ++;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalArgumentException("stack empty.");
        }

        Node node = head;
        head = node.next;
        node.next = null;
        size --;
        return node.data;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        //return super.toString();
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            stringBuilder.append(cur.data);
            if (cur.next != null) {
                stringBuilder.append(" ← ");
            }
            cur = cur.next;
        }
        return stringBuilder.toString();
    }

    private static class Node  {

        int data;
        Node next;

        public Node() {}

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
