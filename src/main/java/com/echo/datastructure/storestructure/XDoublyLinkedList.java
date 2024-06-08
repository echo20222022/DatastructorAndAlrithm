package com.echo.datastructure.storestructure;

/**
 * 双向链表.
 * @author dongzhang
 * */
public class XDoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    /**
     * 判空：head.next = tail || tail.prev = head || size == 0
     * 添加：newNode.next = cur.next;
     *      cur.next.prev = newNode;
     *      cur.next = newNode;
     *      size ++;
     * 删除：delNode
     *      prevNode.next = delNode.next;
     *      delNode.next.prev = prevNode;
     *      deleNode.next = null;
     *      delNode.prev = null;
     *      size --;
     * */

    //1. 初始化
    public XDoublyLinkedList() {
        head = new Node();
        tail = new Node(null, null, head);
        head.next = tail;
        size = 0;
    }



    //2. 添加
    public void addHead(Integer data) {
        Node newNode = new Node(data, head.next, head);
        head.next.prev = newNode;
        head.next = newNode;
        size ++;
    }

    public void addTail(Integer data) {
        Node newNode = new Node(data, tail, null);
        Node tailPre = tail.prev;
        tail.prev = newNode;
        tailPre.next = newNode;
        size ++;
    }

    public void add(int idx, Integer data) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("idx error");
        }

        Node cur = head;
        for (int i = 0;i < idx;i ++) {
            cur = cur.next;
        }

        Node newNode = new Node(data, cur.next, cur);
        //newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next = newNode;
        size ++;
    }

    //3. 修改
    public void set(int idx, Integer data) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("idx error");
        }

        Node cur = head;
        for (int i = 0;i <= idx;i ++) {
            cur = cur.next;
        }
        cur.data = data;
    }

    //4. 删除
    public void remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("idx error");
        }

        Node cur = head;
        for (int i = 0;i < idx;i ++) {
            cur = cur.next;
        }

        Node delNode = cur.next;
        cur.next = delNode.next;
        delNode.next.prev = cur;

        delNode.prev = null;
        delNode.next = null;
        size --;
    }

    //5. 查找
    public Integer getIdx(int data) {
        Node cur = head.next;
        int idx = 0;
        while (cur != tail) {
            if (data == cur.data) {
                return idx;
            }
            idx ++;
            cur = cur.next;
        }
        return -1;
    }

    public Integer get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("idx error");
        }

        Node cur = head;
        for (int i = 0;i <= idx;i ++) {
            cur = cur.next;
        }
        return cur.data;
    }

    public boolean contains(int data) {
        int idx = getIdx(data);
        return idx != -1;
    }

    //6. 打印
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (size == 0) {
            stringBuilder.append("]");
        } else {
            Node cur = head.next;
            for (int i = 0;i < size;i ++) {
                stringBuilder.append(cur.data);
                if (i < size - 1) {
                    stringBuilder.append(",");
                }
                cur = cur.next;
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }

    private class Node {
        Integer data;
        Node next;
        Node prev;
        public Node() {}

        public Node(Integer data) {}

        public Node(Integer data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        XDoublyLinkedList list = new XDoublyLinkedList();
        list.addHead(1);
        list.addHead(2);
        list.addHead(3);
        System.out.println(list);
        list.addTail(4);
        list.addTail(5);
        System.out.println(list);
        list.add(1, 10);
        list.add(3, 20);
        System.out.println(list);
        list.set(3, 100);
        System.out.println(list);
        list.remove(6);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.println(list.getIdx(10));
        System.out.println(list.getIdx(4));
        System.out.println(list.get(3));
        System.out.println(list.get(0));
        System.out.println(list.contains(3));
        System.out.println(list.contains(1));
        System.out.println(list.contains(4));
        System.out.println(list.contains(5));
    }

}
