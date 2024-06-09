package com.echo.datastructure.storestructure.stack;

/**
 * 用数组实现栈.
 * */
public class ArrayStack {

    /**
     * 1. 初始化
     * 2. 入栈
     * 3. 出栈
     * 4. 打印
     * */

    private int[] data;
    private int size;

    public ArrayStack(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public void push(int e) {
        if (data.length == size) {
            throw new IllegalArgumentException("stack full.");
        }
        data[size] = e;
        size ++;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalArgumentException("stack empty");
        }
        int popE = data[size -1];
        size --;
        return popE;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < size;i ++) {
            stringBuilder.append(data[i]);
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

}
