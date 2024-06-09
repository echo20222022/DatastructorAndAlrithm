package com.echo.leetcode;

import java.util.Stack;

/**
 * 有效括号.
 * */
public class CN_20_IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != 'c') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
