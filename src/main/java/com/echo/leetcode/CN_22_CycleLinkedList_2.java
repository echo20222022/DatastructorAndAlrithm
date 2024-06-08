package com.echo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表-2  找到入环的节点.
 * */
public class CN_22_CycleLinkedList_2 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
