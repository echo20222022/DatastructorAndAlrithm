package com.echo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环型链表-判断是否有环
 * */
public class CN_141_CycleLinkedList_1 {

    /**
     * 解题思路
     * 1. 用map存储遍历过的节点，如果存在，就说明存在环
     * 2. 快慢指针，如果存在环，那么快指针和满指针都会在环内打转
     *    快指针相对于慢指针的速度为1，所以迟早快慢指针会重合
     *    如果重合了，就说明存在huan
     * */

    //快慢指针
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //利用set存储已经遍历过的节点
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }


    private static  class ListNode {
      int val;
      ListNode next;

      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
