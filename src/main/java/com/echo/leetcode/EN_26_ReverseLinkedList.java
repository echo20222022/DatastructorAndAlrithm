package com.echo.leetcode;


/**
 * 链表反转.
 * */
public class EN_26_ReverseLinkedList {


    //递归实现
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    //非递归实现
    public ListNode reverseList2(ListNode head) {
        ListNode prev, cur, next;
        prev = null;
        cur = head;
        next = null;

        while (cur != null) {
            next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
