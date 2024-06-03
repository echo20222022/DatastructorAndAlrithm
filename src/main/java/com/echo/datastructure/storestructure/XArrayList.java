package com.echo.datastructure.storestructure;

import java.util.Arrays;

/**
 * 基于数组实现的线性存储.
 * @author dongzhang
 * */
public class XArrayList {

    private int[] data;
    private int size;
    //1. 初始化和
    public XArrayList(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    //2.插入-末尾插
    public void add(int e) {
        growingUp();
        data[size] = e;
        size ++;
    }

    //2.1.插入-指定位置插
    public void add(int e, int idx) {
        growingUp();
        //将指定位置及其之后的数据向后移动一位
        for (int i = size ;i > idx ; i --) {
            data[i] = data[i - 1];
        }
        data[idx] = e;
        size ++;
    }

    //2.2 动态扩容
    private void growingUp() {
        if (data.length == size) {
            int[] newData = new int[data.length / 2 + data.length];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    //3.删除
    public void remove(int e) {
        int idx = getIdx(e);
        if (idx != -1) {
            removeByIds(idx);
        }
    }

    private int getIdx(int e) {
        int idx = -1;
        for (int i = 0;i < data.length;i ++ ) {
            if (data[i] == e) {
                idx = i;
            }
        }
        return idx;
    }

    public void removeByIds(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("无效索引");
        }
        //将删除位置后面的元素向后移动一位
        for (int i = idx;i < size - 1; i ++) {
            data[i] = data[i + 1];
        }
        size -- ;
    }

    //4.查找
    public int get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("无效索引");
        }
        return data[idx];
    }

    public boolean contains(int e) {
        boolean res = false;
        if (size > 0) {
            for (int i = 0;i < size;i ++) {
                if (data[i] == e) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    //6.打印
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0;i < size; i ++) {
            stringBuilder.append(data[i]);
            if (i != size -1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    //5. 测试
    public static void main(String[] args) {
        XArrayList list = new XArrayList(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4, 1);///;
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.contains(4));
        list.remove(4);
        System.out.println(list);
        list.remove(10);
        System.out.println(list);
    }

}
