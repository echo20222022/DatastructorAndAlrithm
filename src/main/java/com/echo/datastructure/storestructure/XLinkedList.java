package com.echo.datastructure.storestructure;

/**
 * 单向链表.
 * @author dongzhang
 * */
public class XLinkedList {

    private Node dummyHead;
    private int size;

    //1. 初始化
    public XLinkedList() {
        dummyHead = new Node();
    }

    //2. 添加数据(尾部添加)
    public void add(Integer data) {

        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        Node newNode = new Node(data, null);
        cur.next = newNode;
        size ++;
    }

    //3. 删除数据
    public void delete(int data) {
        int delIdx = getIdx(data);
        Node cur = dummyHead;
        for (int i = 0;i < delIdx;i ++) {
            cur = cur.next;
        }
        Node delNode = cur.next;
        cur.next = delNode.next;
        delNode.next = null;
        size --;
    }

    public int getIdx(int data) {
        int idx = -1;
        Node cur = dummyHead.next;
        for (int i = 0;i < size;i ++) {
            if (cur.data == data) {
                idx = i;
                break;
            }
            cur = cur.next;
        }

        return idx;
    }

    //4. 查找数据
    public Integer get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("index error.");
        }
        Node cur = dummyHead;
        for (int i = 0;i <= idx;i ++) {
            cur = cur.next;
        }
        return cur.data;
    }

    public boolean contains(int data) {
       return getIdx(data) != -1;
    }

    //5. 打印
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node cur = dummyHead.next;

        while (cur != null) {
            stringBuilder.append(cur.data);
            if (cur.next != null) {
                stringBuilder.append(",");
            }
            cur = cur.next;
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static class Node{
        Integer data;
        Node next;
        public Node() {}
        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        XLinkedList list = new XLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.getIdx(2));
        list.delete(3);
        System.out.println(list);
        list.delete(1);
        System.out.println(list);
        list.delete(4);
        System.out.println(list);
        System.out.println(list.contains(2));
        System.out.println(list.contains(6));
    }
}
