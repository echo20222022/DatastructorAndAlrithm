package com.echo.leetcode;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * */
public class CN_155_MinStack {


    /**
     * 思路：用两个栈实现，一个用来存数据，一个用来存最大值.
     * */

    Stack<Integer> data;
    Stack<Integer> minData;

    public CN_155_MinStack() {
        data = new Stack();
        minData = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        if (minData.isEmpty() || minData.peek() <= val) {
            minData.push(val);
        }
    }

    public void pop() {
        //等于的时候才pop，因为minData中的数据量小于data
        if (data.peek() == minData.peek()) {
            minData.pop();
        }
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minData.peek();
    }
}
