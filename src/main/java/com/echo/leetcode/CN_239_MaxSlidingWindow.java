package com.echo.leetcode;

import java.util.PriorityQueue;

/**
 * 滑动窗口最大值.
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 * */
public class CN_239_MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        int n = nums.length;
        //存储结果的数组
        int[] res = new int[n - k + 1];

        //用一个大顶堆来计算每一次窗口移动过程中的最大值
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) ->
                o2 - o1
        );

        for (int i = 0;i < n;i ++) {
            int start = i - k;
            if (start >= 0) {
                //移除床的左边界
                maxPQ.remove(nums[start]);
            }
            maxPQ.offer(nums[i]);
            //计算最大值
            if (maxPQ.size() == k) {
                res[i - k + 1] = maxPQ.peek();
            }
        }
        return res;
    }
}
