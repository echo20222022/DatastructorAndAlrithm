package com.echo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * */
public class CN_15_ThreeSum {

    /**
     * 解题思路：
     * 1. 暴力求解-三层遍历
     * 2. 夹b法
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return res;
        }

        //排序
        Arrays.sort(nums);

        for (int i = 0;i < nums.length;i ++) {

            //如果当前值已经>0了，那后面的数字不可能和为0
            if (nums[i] > 0) {
                break;
            }

            //跳过重复数据
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //夹b指针
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                //找到了
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    //跳过重复数据
                    while (l < r && nums[l] == nums[l + 1])
                        l ++;
                    while (l < r && nums[r] == nums[r - 1])
                        r --;
                } else if (sum > 0){
                    r --;
                } else {
                    l ++;
                }
            }
        }
        return res;
    }
}
