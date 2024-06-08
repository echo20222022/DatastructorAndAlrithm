package com.echo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和.
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * */
public class CN_1_TwoSum {

    /**
     * 解题思路：
     * - 双层循环
     * - 哈希表记录法
     * */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }

        for (int i = 0;i < nums.length;i ++) {
            for (int j = i; j < nums.length;j ++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * 遍历map，记录 数-索引 的映射
     * 然后找当前值和target对应的差值，如果有，那就存在两数之和=target
     * */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
