package com.echo.leetcode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * */
public class CN_24_SwapPairs {


    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode next = head.next;
        ListNode nextTwo;

        if (next != null) {
            nextTwo = next.next;
            next.next = head;
            head.next = swapPairs(nextTwo);
            return next;
        } else {
            return head;
        }
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
