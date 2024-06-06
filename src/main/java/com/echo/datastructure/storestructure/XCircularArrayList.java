package com.echo.datastructure.storestructure;

/**
 * 通过数组实现循环链表
 * 1. 初始容量
 * 2. 连表长度 = 数组长度-1
 * 3. 空定义 front = end
 * 4. 满定义 end + 1 % array.lenght
 * 5. 打印链表
 * */
public class XCircularArrayList {

    private int[] data;
    private int size;

    int front ;
    int end ;

    public XCircularArrayList(int capacity) {
        data = new int[capacity + 1];
        size = 0;

        front = end = 0;
    }

    /**
     * 逻辑说明：
     * newIdx = (end + 1) % data.length;
     * (end + 1) % data.length == front
     * end == front
     * */

    /**
     * 在头部添加.
     * @param e
     * */
    public void add(int e) {
        if ((end + 1) % data.length == front) {
            throw new IllegalArgumentException("list full.");
        }
        data[end] = e;
        end = (end + 1) % data.length;
        size ++ ;
    }

    /**
     * 在尾部移除.
     * */
    public int remove() {
        if (front == end) {
            throw new IllegalArgumentException("list empty.");
        }
        int removeData = data[front];
        front = (front + 1) % data.length;
        size --;
        return removeData;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (front == end) {
            stringBuilder.append("]");
        } else {
            for (int i = front;
                 i != (end)%data.length;
                 i = (i + 1) % data.length) {
                stringBuilder.append(data[i]);
                if (i == end - 1) {
                    stringBuilder.append("]");
                } else {
                    stringBuilder.append(",");
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        XCircularArrayList list = new XCircularArrayList(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //list.add(5);
        System.out.println(list);

        System.out.println(list.remove());
        System.out.println(list.remove());

        System.out.println(list);
        list.remove();
        System.out.println(list.getSize());
    }

}
