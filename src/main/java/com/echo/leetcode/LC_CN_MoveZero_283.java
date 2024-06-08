package com.echo.leetcode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * */
public class LC_CN_MoveZero_283 {

    /**
     * 解题思路：
     *   双指针 p1, p2，p1指向最后一个非0的位置，p2从头到尾遍历数组
     *   如果遇到非0的，就把p2的数据放到p1+1的位置，然后p1+1，p2+1
     *   最后将p1及之后的数据处理成0
     *
     * 时间复杂的: O(n)
     * 空间复杂的： 无需开辟额外存储空间
     * */
    public void moveZeroes(int[] nums) {
        //空数组或只有一个数据的数据不需要处理
        if (nums == null || nums.length <= 1) {
            return;
        }

        int p1 = 0, p2 = 0;
        for (;p2 < nums.length; p2 ++) {
            int cur = nums[p2];
            if (cur != 0) {
                nums[p1] = cur;
                p1 ++;
            }
        }

        //将p1及之后的数据都处理成0
        for (;p1 < nums.length; p1 ++) {
            nums[p1] = 0;
        }
    }
}
